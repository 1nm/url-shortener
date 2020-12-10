package com.github.`1nm`.demo.url.shortener

import org.springframework.data.annotation.Id
import java.time.LocalDateTime
import java.util.*

data class ShortUrl(
    @Id var id: Long? = null,
    val url: String,
    val key: String = UUID.randomUUID().toString() // TODO: use a better id generator e.g. snowflake
) {
    var createdDate: LocalDateTime = LocalDateTime.now()
    var lastModifiedDate: LocalDateTime = LocalDateTime.now()
}