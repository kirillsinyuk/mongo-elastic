package com.kvsinyuk.elasticsearch.domain

data class Name(
    private val firstName: String,
    private val lastName: String,
    private val middleName: String?,
) {

    fun getFullName() = "$lastName $firstName" + (middleName?.let { " $it" } ?: "")
}