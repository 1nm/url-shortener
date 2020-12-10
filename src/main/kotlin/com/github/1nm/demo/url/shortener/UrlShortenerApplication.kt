package com.github.`1nm`.demo.url.shortener

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ShortUrlApplication

fun main(args: Array<String>) {
    runApplication<ShortUrlApplication>(*args)
}
