package com.atguigu.gmall.search.reposltory;

import com.atguigu.gmall.search.bean.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface GoodsReposltory extends ElasticsearchRepository<Goods,Long> {
}
