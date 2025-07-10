package de.jkrech.tutorial.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// runBlocking is a coroutine builder that bridges the non-coroutine world of regular main function with the coroutine world inside this block.
// launch is a coroutine builder that launches a new coroutine without blocking the current thread.
// result: Hello World! (after 1s delay)

fun main() = runBlocking {
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello ")
}

