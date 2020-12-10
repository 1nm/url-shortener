package com.github.`1nm`.demo.url.shortener

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UrlShortenerService(
    @Autowired val urlShortenerRepository: UrlShortenerRepository
) {
    fun findByUrl(url: String): Optional<ShortUrl> {
        return urlShortenerRepository.findByUrl(url)
    }

    fun findByKey(key: String): Optional<ShortUrl> {
        return urlShortenerRepository.findByKey(key)
    }

    fun save(shortUrl: ShortUrl): ShortUrl {
        urlShortenerRepository.save(shortUrl)
        return shortUrl
    }

    fun get(id: UUID): Optional<ShortUrl> {
        return urlShortenerRepository.findById(id)
    }
}