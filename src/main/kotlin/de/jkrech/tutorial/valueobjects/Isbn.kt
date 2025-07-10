package de.jkrech.tutorial.valueobjects

@JvmInline
value class Isbn(private val input: String) {
    val value: String
        get() = input.trim()

    init {
        require(value.isNotBlank()) {
            "Value shouldn't be empty"
        }
        require(isValidIsbn(value)) {
            "Invalid ISBN format"
        }
    }

    private fun isValidIsbn(value: String): Boolean {
        val normalizedValue = value.replace("-", "")

        return when {
            normalizedValue.length == 10 -> isValidIsbn10(normalizedValue)
            normalizedValue.length == 13 && (normalizedValue.startsWith("978") || normalizedValue.startsWith("979")) ->
                isValidIsbn13(normalizedValue)
            else -> false
        }
    }

    private fun isValidIsbn10(isbn: String): Boolean {
        if (!isbn.substring(0, 9).all { it.isDigit() } ||
            !(isbn[9].isDigit() || isbn[9] == 'X')) {
            return false
        }

        // checksum for ISBN-10
        var sum = 0
        for (i in 0..8) {
            sum += (isbn[i] - '0') * (10 - i)
        }

        val checkDigit = if (isbn[9] == 'X') 10 else isbn[9] - '0'
        return (sum + checkDigit) % 11 == 0
    }

    private fun isValidIsbn13(isbn: String): Boolean {
        if (!isbn.all { it.isDigit() }) {
            return false
        }

        // checksum für ISBN-13
        var sum = 0
        for (i in 0..12) {
            sum += (isbn[i] - '0') * (if (i % 2 == 0) 1 else 3)
        }

        return sum % 10 == 0
    }
}