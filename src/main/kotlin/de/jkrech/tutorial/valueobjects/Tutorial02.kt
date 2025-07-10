package de.jkrech.tutorial.valueobjects

fun main() {
    val validIsbn13 = Isbn("978-0-321-12521-7")
    println("ISBN 13: ${validIsbn13.value}")

    val validIsbn10 = Isbn("0321125215")
    println("ISBN 10: ${validIsbn10.value}")

    try {
        Isbn("  ") // This will throw an exception
    } catch (exc: Exception) {
        println("Caught an exception: ${exc.message}")
    }

    try {
        Isbn("123456") // This will throw an exception
    } catch (exc: Exception) {
        println("Caught an exception: ${exc.message}")
    }
}