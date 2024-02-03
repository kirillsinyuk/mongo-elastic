package com.kvsinyuk.elasticsearch.application.impl

import com.kvsinyuk.elasticsearch.application.port.GenerateDealsUseCase
import com.kvsinyuk.elasticsearch.application.port.SaveDealPort
import com.kvsinyuk.elasticsearch.utils.generateDeal
import org.springframework.stereotype.Component

@Component
class GenerateDealsUseCaseImpl(
    private val saveDealPort: SaveDealPort
): GenerateDealsUseCase {

    override fun generateDeals(dealAmount: Int) {
        for (i in 0 until dealAmount) {
            saveDealPort.save(generateDeal())
        }
    }
}