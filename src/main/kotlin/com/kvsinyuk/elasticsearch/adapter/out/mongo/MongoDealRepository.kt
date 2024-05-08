package com.kvsinyuk.elasticsearch.adapter.out.mongo

import com.kvsinyuk.elasticsearch.domain.Deal
import org.bson.types.ObjectId
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface MongoDealRepository : MongoRepository<Deal, ObjectId> {
    @Query("{ \$text: { \$search: ?0 } }")
    fun searchDeal(
        search: String,
        page: Pageable,
    ): Page<Deal>
}
