package com.kvsinyuk.elasticsearch.adapter.out.mongo

import com.kvsinyuk.elasticsearch.application.port.SaveDealPort
import com.kvsinyuk.elasticsearch.domain.Deal
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface DealRepository : MongoRepository<Deal, ObjectId>, SaveDealPort