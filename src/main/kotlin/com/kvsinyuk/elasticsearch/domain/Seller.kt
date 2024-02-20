package com.kvsinyuk.elasticsearch.domain

import java.util.UUID

class Seller {
    val id: String = UUID.randomUUID().toString()

    lateinit var name: Name

    lateinit var contacts: Contacts
}
