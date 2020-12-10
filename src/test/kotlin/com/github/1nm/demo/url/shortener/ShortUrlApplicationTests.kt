package com.github.`1nm`.demo.url.shortener

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ShortUrlApplicationTests(@Autowired val urlShortenerService: UrlShortenerService) {

    @Test
    fun test() {
        val shortUrl = ShortUrl(url = "https://google.com")
        urlShortenerService.save(shortUrl)
        println(shortUrl)
    }

}
