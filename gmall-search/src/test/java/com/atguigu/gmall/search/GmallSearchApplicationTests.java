package com.atguigu.gmall.search;

import com.atguigu.gmall.pms.entity.*;
import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.common.bean.ResponseVo;
import com.atguigu.gmall.wms.entity.WareSkuEntity;
import com.atguigu.gmall.search.bean.Goods;
import com.atguigu.gmall.search.bean.SearchAttrsValie;
import com.atguigu.gmall.search.feign.GmallPmsClient;
import com.atguigu.gmall.search.feign.GmallWmsClient;
import com.atguigu.gmall.search.reposltory.GoodsReposltory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class GmallSearchApplicationTests {
    @Autowired
    private ElasticsearchRestTemplate restTemplate;

    @Autowired
    private GoodsReposltory reposltory;

    @Autowired
    private GmallPmsClient pmsClient;

    @Autowired
    private GmallWmsClient gmallWmsClient;

    @Test
    void contextLoads() {
        this.restTemplate.createIndex(Goods.class);
        this.restTemplate.putMapping(Goods.class);
    }

    @Test
    void importDate(){
        Integer pageName = 1;
        Integer pageSize = 100;
        do {

            PageParamVo paramVo = new PageParamVo();
            paramVo.setPageNum(pageName);
            paramVo.setPageSize(pageSize);
            ResponseVo<List<SpuEntity>> listResponseVo = this.pmsClient.querySpusByPage(paramVo);
            List<SpuEntity> spuEntities = listResponseVo.getData();
            if (CollectionUtils.isEmpty(spuEntities)){
                return;
            }
            spuEntities.forEach(spuEntity -> {
                ResponseVo<List<SkuEntity>>  skuListResponseVo= this.pmsClient.querySkuBySpuId(spuEntity.getId());
                List<SkuEntity> skuEntities = skuListResponseVo.getData();
                if (CollectionUtils.isEmpty(skuEntities)){
                    List<Goods> goodsList = skuEntities.stream().map(sku -> {
                        Goods goods = new Goods();
                        goods.setSkuId(sku.getId());
                        goods.setTitle(sku.getTitle());
                        goods.setPrice(sku.getPrice().doubleValue());
                        goods.setDefaultImage(sku.getDefaultImage());
                        //查寻品牌
                        ResponseVo<BrandEntity> brandEntityResponseVo = this.pmsClient.queryBrandById(sku.getBrandId());
                        BrandEntity brandEntity = brandEntityResponseVo.getData();
                        if (brandEntity != null){
                            goods.setBrandId(sku.getBrandId());
                            goods.setBrandName(brandEntity.getName());
                            goods.setLogo(brandEntity.getLogo());
                        }
                        //查询分类相关数据
                        ResponseVo<CategoryEntity> categoryEntityResponseVo = this.pmsClient.queryCategoryById(sku.getCategoryId());
                        CategoryEntity categoryEntity = categoryEntityResponseVo.getData();
                        if (categoryEntity != null){
                            goods.setCategoryId(sku.getCategoryId());
                            goods.setCategoryName(categoryEntity.getName());
                        }

                        goods.setCreateTime(spuEntity.getCreateTime());
                        ResponseVo<List<WareSkuEntity>> queryWareSkuBySkuId = this.gmallWmsClient.queryWareSkuBySkuId(sku.getId());
                        List<WareSkuEntity> wareSkuEntities = queryWareSkuBySkuId.getData();
                        if (!CollectionUtils.isEmpty(wareSkuEntities)){
                            goods.setSales(wareSkuEntities.stream().map(WareSkuEntity::getSales).reduce((a,b)-> a + b).get());
                            goods.setStore(wareSkuEntities.stream().anyMatch(wareSkuEntity -> wareSkuEntity.getStock()>0));
                        }
                        ResponseVo<List<AttrEntity>> arreResponseVo = this.pmsClient.queryAttrsByCid(sku.getCategoryId(), null, 1);
                        List<AttrEntity> attrEntities = arreResponseVo.getData();
                        if (!CollectionUtils.isEmpty(attrEntities)){
                            List<Long> attrIds = attrEntities.stream().map(AttrEntity::getId).collect(Collectors.toList());
                            List<SearchAttrsValie> searchAttrsValies = new ArrayList<>();
                            ResponseVo<List<SkuAttrValueEntity>> skuAttrValuesponseVo = this.pmsClient.querySkuSearchAttrValue(sku.getId(), attrIds);
                            ResponseVo<List<SpuAttrValueEntity>> spuAttrValuesponseVo = this.pmsClient.querySpuSearchAttrValue(spuEntity.getId(), attrIds);
                            List<SkuAttrValueEntity> skuAttrValueEntities = skuAttrValuesponseVo.getData();
                            List<SpuAttrValueEntity> spuAttrValueEntities = spuAttrValuesponseVo.getData();
                            if (!CollectionUtils.isEmpty(skuAttrValueEntities)){
                                searchAttrsValies.addAll(skuAttrValueEntities.stream().map(skuAttrValueEntity -> {
                                    SearchAttrsValie searchAttrsValie = new SearchAttrsValie();
                                    BeanUtils.copyProperties(skuAttrValueEntity,searchAttrsValie);
                                    return searchAttrsValie;
                                }).collect(Collectors.toList()));
                            }
                            if (!CollectionUtils.isEmpty(spuAttrValueEntities)){
                                searchAttrsValies.addAll(spuAttrValueEntities.stream().map(spuAttrValueEntity -> {
                                    SearchAttrsValie searchAttrsValie = new SearchAttrsValie();
                                    BeanUtils.copyProperties(spuAttrValueEntity,searchAttrsValie);
                                    return searchAttrsValie;
                                }).collect(Collectors.toList()));
                            }
                            goods.setSearchAttrs(searchAttrsValies);
                        }
                        return goods;
                    }).collect(Collectors.toList());
                    this.reposltory.saveAll(goodsList);
                }
            });


            pageName++;
            pageSize = spuEntities.size();
        }while (pageSize == 100);
    }
}
