package de.jkrech.tutorial.valueobjects

fun main() {
    val validId = VeryImportantId("123456789")
    println("ID: ${validId.value}")

    try {
        VeryImportantId("  ") // This will throw an exception
    } catch (exc: Exception) {
        println("Caught an exception: ${exc.message}")
    }
}