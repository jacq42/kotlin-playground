package de.jkrech.tutorial.scopefunctions

import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("Scope Functions Tutorial")
    println("=====================================")
    exampleForLet()
    exampleForLetOnNullValues("Buxtehude")
    exampleForLetOnNullValues()
    println("=====================================")
    exampleForWith()
    println("=====================================")
    exampleForRun()
    println("=====================================")
    exampleForApply()
    println("=====================================")
    exampleForAlso()
}

private fun exampleForLet() {
    println("Example for 'let'")
    val numbers = mutableListOf("one", "two", "three", "four", "five")
    numbers
        .apply { println(this) }
        .map { it.length }
        .filter { it > 3 }
        .let {
            println(it)
        }
}

private fun exampleForLetOnNullValues(value: String? = null) {
    println("Example for 'let' on possible null values")
    value?.let { println(it) }
}

private fun exampleForWith() {
    println("Example for 'with'")
    val numbers = mutableListOf("one", "two", "three")
    val firstAndLast = with(numbers) {
        "The first element is ${first()}," +
                " the last element is ${last()}"
    }
    println(firstAndLast)
}

private fun exampleForRun() {
    println("Example for 'run'")
    val hexNumberRegex = run {
        val digits = "0-9"
        val hexDigits = "A-Fa-f"
        val sign = "+-"

        Regex("[$sign]?[$digits$hexDigits]+")
    }

    for (match in hexNumberRegex.findAll("+123 -FFFF !%*& 88 XYZ")) {
        println(match.value)
    }
}

private fun exampleForApply() {
    println("Example for 'apply'")
    val adam = Person("Adam").apply {
        age = 32
        city = "London"
    }
    println(adam)
}

private fun exampleForAlso() {
    println("Example for 'also'")
    val numbers = mutableListOf("one", "two", "three")
    numbers
        .also { println("The list elements before adding new one: $it") }
        .add("four")
    println(numbers)
}

