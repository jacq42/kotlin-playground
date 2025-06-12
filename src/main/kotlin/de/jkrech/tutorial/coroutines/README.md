# Coroutines

See [Coroutines Guide](https://kotlinlang.org/docs/coroutines-guide.html)

* Feature for asynchronous and non-blocking programming
* It is conceptually similar to a thread
* Managed by the Kotlin runtime and not by the OS
* Why?
  * Perform long-running tasks without blocking the main thread
  * Alternative to callbacks and RxJava
  * Improve app performance and responsiveness
  
* Function marked with `suspend` can be paused and resumed
  * can only be called from a coroutine or other suspend function
* Coroutine Builders:
  * `launch`: Starts a new coroutine and returns a `Job` object
  * `async`: Starts a new coroutine and returns a `Deferred` object (just like `Future` or `promise`)
  * `runBlocking`: Blocks the current thread until the coroutine finishes
* Scopes:
  * `GlobalScope`: Global coroutines that live as long as the application
  * `lifecycleScope`, `viewModelScope`: Android-specific lifecycle-aware scopes