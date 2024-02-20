package com.kvsinyuk.elasticsearch.domain

data class Name(
    val firstName: String,
    val lastName: String,
    val middleName: String?,
) {
    fun getFullName() = "$lastName $firstName" + (middleName?.let { " $it" } ?: "")
}
