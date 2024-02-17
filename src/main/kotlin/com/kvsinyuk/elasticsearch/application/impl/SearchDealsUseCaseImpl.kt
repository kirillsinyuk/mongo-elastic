package com.kvsinyuk.elasticsearch.application.impl

import com.kvsinyuk.elasticsearch.adapter.out.elasticsearch.ElasticDealRepository
import com.kvsinyuk.elasticsearch.application.port.SearchDealsUseCase
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

@Component
class SearchDealsUseCaseImpl(
    private val dealRepository: ElasticDealRepository
): SearchDealsUseCase {

    override fun searchDeals(search: String, page: Pageable) =
        dealRepository.searchAll(search, page)
}