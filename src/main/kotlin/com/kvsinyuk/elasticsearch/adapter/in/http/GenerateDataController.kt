package com.kvsinyuk.elasticsearch.adapter.`in`.http

import com.kvsinyuk.elasticsearch.application.port.GenerateDealsUseCase
import mu.KLogging
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GenerateDataController(
    private val generateDealsUseCase: GenerateDealsUseCase,
) {
    @PostMapping("/generate")
    fun generateRandomData(
        @RequestParam dealAmount: Int,
    ) {
        logger.info { "Received request for $dealAmount deals generation" }
        generateDealsUseCase.generateDeals(dealAmount)
    }

    companion object : KLogging()
}
