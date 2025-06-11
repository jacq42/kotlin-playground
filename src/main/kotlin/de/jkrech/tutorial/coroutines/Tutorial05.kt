package de.jkrech.tutorial.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// launch returns a Job object

fun main() = runBlocking {
    val job = launch {
        delay(1000L)
        println("World!")
    }

    println("Hello")
    job.join()
    println("Done")
}

