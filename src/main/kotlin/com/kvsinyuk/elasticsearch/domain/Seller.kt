package com.kvsinyuk.elasticsearch.domain

import java.util.UUID

class Seller {

    private val id: UUID = UUID.randomUUID()

    private lateinit var name: Name

    private lateinit var contacts: Contacts
}