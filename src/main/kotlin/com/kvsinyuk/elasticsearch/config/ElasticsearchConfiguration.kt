package com.kvsinyuk.elasticsearch.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories

@Configuration
@EnableElasticsearchRepositories(basePackages = ["com.kvsinyuk.elasticsearch.adapter.out.elasticsearch"])
@ComponentScan(basePackages = ["com.kvsinyuk.elasticsearch"])
class ElasticsearchConfiguration
