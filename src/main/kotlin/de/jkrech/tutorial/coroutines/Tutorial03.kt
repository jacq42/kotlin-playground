package de.jkrech.tutorial.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// coroutineScope declares own scope. Does not complete until all children complete.
// runBlocking is a regular function that blocks the current thread.
// coroutineScope is a suspending function that does not block the current thread.

fun main() = runBlocking {
    doWorld03()
}

suspend fun doWorld03() = coroutineScope {
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello ")
}

