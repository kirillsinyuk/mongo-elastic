package com.kvsinyuk.elasticsearch.domain

import java.util.UUID

class Buyer {

    val id: String = UUID.randomUUID().toString()

    lateinit var name: Name

    lateinit var contacts: Contacts
}