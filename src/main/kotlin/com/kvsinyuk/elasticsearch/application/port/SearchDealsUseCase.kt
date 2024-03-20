package com.kvsinyuk.elasticsearch.application.port

import com.kvsinyuk.elasticsearch.domain.Deal
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface SearchDealsUseCase {
    fun searchDeals(command: SearchCommand): Page<Deal>

    data class SearchCommand(
        val search: String,
        val databaseType: String,
        val page: Pageable,
    )
}
