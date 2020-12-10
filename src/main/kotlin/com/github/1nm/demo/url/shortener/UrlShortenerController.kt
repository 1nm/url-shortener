package com.github.`1nm`.demo.url.shortener

import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/v1")
class UrlShortenerController(@Autowired private val urlShortenerService: UrlShortenerService) {
    @PostMapping(
        value = ["encode"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @Operation(summary = "Shorten the given long URL")
    fun encode(
        @RequestBody
        request: DAO.ShortenRequest
    ): DAO.ShortenResponse {
        val shortUrl: ShortUrl = urlShortenerService.findByUrl(request.url).orElse(ShortUrl(url = request.url))
        shortUrl.lastModifiedDate = LocalDateTime.now()
        urlShortenerService.save(shortUrl)
        return DAO.ShortenResponse(
          shortUrl.url,
          shortUrl.key,
          shortUrl.createdDate,
          shortUrl.lastModifiedDate
        )
    }

    @GetMapping(value = ["decode/{key}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    @Operation(summary = "Expand the given short URL")
    fun decode(@PathVariable("key") key: String): DAO.ShortenResponse {
        val shortUrl = urlShortenerService.findByKey(key)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Short URL with key $key does not exist") }
        return DAO.ShortenResponse(
          shortUrl.url,
          key,
          shortUrl.createdDate,
          shortUrl.lastModifiedDate
        )
    }
}