package com.kvsinyuk.elasticsearch.application.impl

import com.kvsinyuk.elasticsearch.adapter.out.elasticsearch.ElasticDealRepository
import com.kvsinyuk.elasticsearch.adapter.out.mongo.MongoDealRepository
import com.kvsinyuk.elasticsearch.application.port.SearchDealsUseCase
import com.kvsinyuk.elasticsearch.application.port.SearchDealsUseCase.SearchCommand
import org.springframework.stereotype.Component

@Component
class SearchDealsUseCaseImpl(
    private val elasticDealRepository: ElasticDealRepository,
    private val mongoDealRepository: MongoDealRepository,
) : SearchDealsUseCase {
    override fun searchDeals(command: SearchCommand) =
        when (command.databaseType) {
            "elasticsearch" -> elasticDealRepository.searchAll(command.search, command.page)
            else -> mongoDealRepository.findAll(command.page)
        }
}
