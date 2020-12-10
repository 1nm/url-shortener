package com.github.`1nm`.demo.url.shortener

object Base62 {
    private fun charToInt(c: Char): Int {
        return when (c) {
            in '0'..'9' -> {
                c - '0'
            }
            in 'A'..'Z' -> {
                c - 'A' + 10
            }
            in 'a'..'z' -> {
                c - 'a' + 36
            }
            else -> {
                throw IllegalArgumentException("Character $c is illegal.")
            }
        }
    }

    private fun intToChar(value: Int): Char {
        return when (value) {
            in 0..9 -> {
                '0' + value
            }
            in 10..35 -> {
                'A' + value - 10
            }
            in 36..61 -> {
                'a' + value - 36
            }
            else -> {
                throw IllegalArgumentException("Value $value is illegal.")
            }
        }
    }

    fun encode(value: Long): String {
        var divided: Long = value
        val sb = StringBuilder()
        while (divided > 0) {
            val mod = (divided % 62).toInt()
            sb.insert(0, intToChar(mod))
            divided /= 62
        }
        return sb.toString()
    }

    fun decode(base62Str: String): Long {
        return base62Str.map { charToInt(it) }.sum().toLong()
    }
}