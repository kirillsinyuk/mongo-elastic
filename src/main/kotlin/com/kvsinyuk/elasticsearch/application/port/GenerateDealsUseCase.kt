package com.kvsinyuk.elasticsearch.application.port

interface GenerateDealsUseCase {
    suspend fun generateDeals(dealAmount: Int)
}
