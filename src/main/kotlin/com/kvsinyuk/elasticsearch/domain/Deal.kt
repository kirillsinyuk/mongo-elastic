package com.kvsinyuk.elasticsearch.domain

import org.bson.types.ObjectId
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant
import java.time.LocalDate

@Document
class Deal {

    lateinit var id: ObjectId

    lateinit var number: String

    lateinit var date: LocalDate

    var sellers: List<Seller> = emptyList()

    var buyers: List<Buyer> = emptyList()

    var guarantors: List<Guarantor> = emptyList()

    @CreatedDate
    lateinit var createdAt: Instant
}