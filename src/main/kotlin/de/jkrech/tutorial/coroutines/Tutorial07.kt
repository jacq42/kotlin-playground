package de.jkrech.tutorial.coroutines

import kotlinx.coroutines.*

// Handling exceptions with try/catch

@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking {
    val job1 = launch {
        doFetchUser(GlobalScope.async {
            fetchUser()
        })
    }
    val job2 = launch {
        doFetchUser(GlobalScope.async {
            fetchUserWithException()
        })
    }
    println("Start")
    job1.join()
    job2.join()
    println("Done")
}

suspend fun doFetchUser(deferredUser: Deferred<String>) {
    println("Start fetching user...")
    delay(2000L)
    try {
        val user = deferredUser.await()
        println("User: $user")
    } catch (exception: Exception) {
        println("Error fetching user: ${exception.message}")
    }
}

suspend fun fetchUser() = coroutineScope {
    return@coroutineScope "user name"
}

suspend fun fetchUserWithException(): Nothing = coroutineScope {
    throw Exception("User not found")
}

