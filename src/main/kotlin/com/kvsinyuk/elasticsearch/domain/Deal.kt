package com.kvsinyuk.elasticsearch.domain

import org.bson.types.ObjectId
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant
import java.time.LocalDate

@Document
class Deal {

    private lateinit var id: ObjectId

    private var number: String? = null

    private lateinit var date: LocalDate

    private var sellers: List<Seller> = emptyList()

    private var buyers: List<Buyer> = emptyList()

    private var guarantors: List<Guarantor> = emptyList()

    @CreatedDate
    private lateinit var createdAt: Instant
}