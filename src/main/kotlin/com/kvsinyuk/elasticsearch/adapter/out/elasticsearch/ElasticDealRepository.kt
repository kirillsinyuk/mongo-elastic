package com.kvsinyuk.elasticsearch.adapter.out.elasticsearch

import com.kvsinyuk.elasticsearch.domain.Deal
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.elasticsearch.annotations.Query
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface ElasticDealRepository : ElasticsearchRepository<Deal, String> {
    @Query(query = "{ \"multi_match\" : {\"query\" : \"?0\" }}")
    fun searchAll(
        search: String,
        page: Pageable,
    ): Page<Deal>
}
