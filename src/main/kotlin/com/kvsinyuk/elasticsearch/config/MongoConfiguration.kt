package com.kvsinyuk.elasticsearch.config

import io.mongock.runner.springboot.EnableMongock
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.EnableMongoAuditing
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@Configuration
@EnableMongock
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = ["com.kvsinyuk.elasticsearch.adapter.out.mongo"])
@ComponentScan(basePackages = ["com.kvsinyuk.elasticsearch"])
class MongoConfiguration
