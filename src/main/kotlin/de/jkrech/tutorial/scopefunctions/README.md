# Scope functions

Execute a block of code within the context of an object.

See [Scope functions](https://kotlinlang.org/docs/scope-functions.html) in Kotlin documentation.

There are 5 functions. The difference between them is how the object becomes available inside the block
and what is the result of the block.

|Function|Object reference|Return value|Is extension function|
|---|---|---|---|
|let|it|Lambda result|Yes|
|run|this|Lambda result|Yes|
|run|-|Lambda result|No: called without the context object|
|with|this|Lambda result|No: takes the context object as an argument|
|apply|this|Context object|Yes|
|also|it|Context object|Yes|

## Let

"Invoke one or more functions on the object"

* The context object is available as an argument (it).
* The return value is the lambda result.

Example:
```kotlin
val numbers = mutableListOf("one", "two", "three", "four", "five")
numbers.map { it.length }
    .filter { it > 3 }
    .let {
        println(it)
    } 
```

## With

"With this object, do the following."

* Is not an extension function.


* The context object is available as a receiver (this).
* The return value is the lambda result.

Example:
```kotlin
val numbers = mutableListOf("one", "two", "three")
val firstAndLast = with(numbers) {
    "The first element is ${first()}," +
    " the last element is ${last()}"
}
println(firstAndLast)
```

## Run

"Useful when your lambda both initializes objects and computes the return value."

* Same as 'with', but is an extension function.


* The context object is available as a receiver (this).
* The return value is the lambda result.

Example:
```kotlin
val hexNumberRegex = run {
    val digits = "0-9"
    val hexDigits = "A-Fa-f"
    val sign = "+-"

    Regex("[$sign]?[$digits$hexDigits]+")
}

for (match in hexNumberRegex.findAll("+123 -FFFF !%*& 88 XYZ")) {
    println(match.value)
}
```

## Apply

"Apply the following assignments to the object."

* Useful for object configuration.


* The context object is available as a receiver (this).
* The return value is the object itself.

Example:
```kotlin
val adam = Person("Adam").apply {
    age = 32
    city = "London"        
}
println(adam)
```

## Also

"And also do the following with the object."

* The context object is available as an argument (it).
* The return value is the object itself.

Example:
```kotlin
val numbers = mutableListOf("one", "two", "three")
numbers
    .also { println("The list elements before adding new one: $it") }
    .add("four")
```