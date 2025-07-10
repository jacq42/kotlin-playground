package de.jkrech.tutorial.valueobjects

@JvmInline
value class VeryImportantId(private val input: String) {
    val value: String
        get() = input.trim()

    init {
        require(value.isNotBlank()) {
            "Id shouldn't be empty"
        }
    }
}