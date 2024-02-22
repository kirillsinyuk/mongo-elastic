package com.kvsinyuk.elasticsearch.adapter.out.elasticsearch

import com.kvsinyuk.elasticsearch.domain.Deal
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.elasticsearch.annotations.Query
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface ElasticDealRepository : ElasticsearchRepository<Deal, String> {
    @Query(
        query = """{ 
        "bool": {
            "should": [
                {
                    "multi_match" : {
                    "query": "?0",
                    "type": "cross_fields",
                    "fields": ["sellers.name.firstName", "sellers.name.lastName", "sellers.name.middleName"],
                    "operator": "and"
                }},
                {
                    "multi_match" : {
                    "query": "?0",
                    "type": "cross_fields",
                    "fields": ["buyers.name.firstName", "buyers.name.lastName", "buyers.name.middleName"],
                    "operator": "and"
                }},
                {
                    "multi_match" : {
                    "query": "?0",
                    "type": "cross_fields",
                    "fields": ["guarantors.name.firstName", "guarantors.name.lastName", "guarantors.name.middleName"],
                    "operator": "and"
                }},
                {
                    "match_phrase_prefix": {
                        "number": {
                          "query": "?0",
                          "max_expansions": 10000
                        }
                    }
                }
            ]
        }
    }""",
    )
    fun searchAll(
        search: String,
        page: Pageable,
    ): Page<Deal>
}
