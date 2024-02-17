package com.kvsinyuk.elasticsearch.application.port

import com.kvsinyuk.elasticsearch.domain.Deal
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface SearchDealsUseCase {

    fun searchDeals(search: String, page: Pageable): Page<Deal>
}