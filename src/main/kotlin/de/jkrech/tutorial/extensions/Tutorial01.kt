package de.jkrech.tutorial.extensions

fun main() {
    val stringValue = "Hello, World!"
    println("Original: $stringValue")
    println("With extension: ${stringValue.addSomething()}")

    // extension with optional values
    val nullableString1 = "Not empty"
    val nullableString2: String? = null
    println("Length of '$nullableString1' = ${nullableString1.lengthOrNull()}")
    println("Length of '$nullableString2' = ${nullableString2.lengthOrNull()}")
}


