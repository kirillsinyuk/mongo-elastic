package com.kvsinyuk.elasticsearch.application.impl

import com.kvsinyuk.elasticsearch.adapter.out.mongo.MongoDealRepository
import com.kvsinyuk.elasticsearch.application.port.GenerateDealsUseCase
import com.kvsinyuk.elasticsearch.utils.generateDeal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class GenerateDealsUseCaseImpl(
    private val dealRepository: MongoDealRepository
): GenerateDealsUseCase {

    @Value("\${generator.batch.count}")
    private var batchCount: Int = 20

    override fun generateDeals(dealAmount: Int) {
        for (i in dealAmount downTo 0 step batchCount) {
            CoroutineScope(Dispatchers.Default).launch {
                (0 until batchCount)
                    .map { generateDeal() }
                    .let { dealRepository.saveAll(it) }
            }
        }
    }
}