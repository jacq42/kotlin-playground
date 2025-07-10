package de.jkrech.tutorial.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// launch returns a Job object, that can be joined to wait for its completion.
// Suspends the current coroutine until the job completes.
// Jobs are cancellable.

fun main() = runBlocking {
    val job = launch {
        delay(1000L)
        println("World!")
    }

    println("Hello")
    job.join()
    println("Done with state: active: ${job.isActive}, completed: ${job.isCompleted}, cancelled: ${job.isCancelled}")
}

