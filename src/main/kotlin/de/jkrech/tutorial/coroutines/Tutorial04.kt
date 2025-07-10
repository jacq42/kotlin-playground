package de.jkrech.tutorial.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// start multiple concurrent operations
// result: prints "Hello" immediately, then "World 1" after 1s and "World 2" after 2s

fun main() = runBlocking {
    doWorld04()
}

suspend fun doWorld04() = coroutineScope {
    launch {
        delay(2000L)
        println("World 2")
    }
    launch {
        delay(1000L)
        println("World 1")
    }
    println("Hello ")
}

