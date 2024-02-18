package com.kvsinyuk.elasticsearch.adapter.`in`.http

import com.kvsinyuk.elasticsearch.application.port.SearchDealsUseCase
import com.kvsinyuk.elasticsearch.domain.Deal
import mu.KLogging
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class DealController(
    private val searchDealsUseCase: SearchDealsUseCase,
) {
    @GetMapping("/deals")
    fun generateRandomData(
        @RequestParam search: String,
        pageable: Pageable,
    ): Page<Deal> {
        logger.info { "Received request for search deals with $search" }
        return searchDealsUseCase.searchDeals(search, pageable)
    }

    companion object : KLogging()
}
