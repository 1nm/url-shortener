package com.github.`1nm`.demo.url.shortener

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UrlShortenerRepository : CrudRepository<ShortUrl, UUID> {
    fun findByUrl(url: String): Optional<ShortUrl>
    fun findByKey(key: String): Optional<ShortUrl>
}