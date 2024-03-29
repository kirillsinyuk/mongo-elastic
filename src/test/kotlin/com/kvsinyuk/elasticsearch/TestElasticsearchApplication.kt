package com.kvsinyuk.elasticsearch

import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.boot.with
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.containers.wait.strategy.LogMessageWaitStrategy
import org.testcontainers.elasticsearch.ElasticsearchContainer
import org.testcontainers.utility.DockerImageName
import java.time.Duration

@TestConfiguration(proxyBeanMethods = false)
class TestElasticsearchApplication {
    @Bean
    @ServiceConnection
    fun elasticsearchContainer(): ElasticsearchContainer {
        return ElasticsearchContainer(
            DockerImageName.parse("bitnami/elasticsearch:latest")
                .asCompatibleSubstituteFor("docker.elastic.co/elasticsearch/elasticsearch"),
        )
            .also {
                it.setWaitStrategy(
                    LogMessageWaitStrategy()
                        .withRegEx(".*started.*").withStartupTimeout(Duration.ofMinutes(3)),
                )
            }
    }

    @Bean
    @ServiceConnection
    fun mongoDbContainer(): MongoDBContainer {
        return MongoDBContainer(DockerImageName.parse("mongo:latest"))
    }
}

fun main(args: Array<String>) {
    fromApplication<ElasticsearchApplication>().with(TestElasticsearchApplication::class).run(*args)
}
