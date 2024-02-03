package com.kvsinyuk.elasticsearch.domain

import java.util.UUID

class Guarantor {

    val id: UUID = UUID.randomUUID()

    lateinit var name: Name

    lateinit var contacts: Contacts
}