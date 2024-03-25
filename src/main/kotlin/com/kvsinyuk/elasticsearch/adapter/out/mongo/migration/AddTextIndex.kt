package com.kvsinyuk.elasticsearch.adapter.out.mongo.migration

import io.mongock.api.annotations.ChangeUnit
import io.mongock.api.annotations.Execution
import io.mongock.api.annotations.RollbackExecution
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.index.TextIndexDefinition.TextIndexDefinitionBuilder

@ChangeUnit(id = "1", order = "1", author = "sinyukkv")
class AddTextIndex {
    @Execution
    fun run(mongoTemplate: MongoTemplate) {
        val textIndex =
            TextIndexDefinitionBuilder()
                .onField("sellers.name.firstName")
                .onField("sellers.name.lastName")
                .onField("sellers.name.middleName")
                .onField("buyers.name.firstName")
                .onField("buyers.name.lastName")
                .onField("buyers.name.middleName")
                .onField("guarantors.name.firstName")
                .onField("guarantors.name.lastName")
                .onField("guarantors.name.middleName")
                .onField("number")
                .named(INDEX_NAME)
                .build()

        mongoTemplate.indexOps("deal").ensureIndex(textIndex)
    }

    @RollbackExecution
    fun rollback(mongoTemplate: MongoTemplate) {
        mongoTemplate.indexOps("deal").dropIndex(INDEX_NAME)
    }

    companion object {
        const val INDEX_NAME = "deal_text_idx"
    }
}
