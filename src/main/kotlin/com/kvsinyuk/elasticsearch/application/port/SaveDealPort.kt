package com.kvsinyuk.elasticsearch.application.port

import com.kvsinyuk.elasticsearch.domain.Deal

interface SaveDealPort {

    fun save(deal: Deal): Deal
}