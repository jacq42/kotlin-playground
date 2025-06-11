package de.jkrech.tutorial.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// coroutines are light-weight: consuming very little memory instead of threads

fun main() = runBlocking {
    repeat(1_000) {
        launch {
            delay(5000L)
            print(".")
        }
    }
}

