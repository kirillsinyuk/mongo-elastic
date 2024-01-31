package com.kvsinyuk.elasticsearch.domain

import java.util.UUID

class Guarantor {

    private val id: UUID = UUID.randomUUID()

    private lateinit var name: Name

    private lateinit var contacts: Contacts
}