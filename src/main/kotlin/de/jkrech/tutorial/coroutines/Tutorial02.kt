package de.jkrech.tutorial.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// suspending functions can be used inside coroutines
// can use other suspending functions
// result: Hello World! (after 1s delay)

fun main() = runBlocking {
    launch { doWorld02() }
    println("Hello ")
}

suspend fun doWorld02() {
    delay(1000L)
    println("World!")
}

