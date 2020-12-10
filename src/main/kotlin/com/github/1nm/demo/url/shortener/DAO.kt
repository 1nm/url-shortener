package com.github.`1nm`.demo.url.shortener

import java.time.LocalDateTime

class DAO {
    data class ShortenResponse(
        val url: String,
        val key: String,
        val createdDate: LocalDateTime,
        val lastModifiedDate: LocalDateTime
    )

    data class ShortenRequest(
        val url: String = "",
    )
}