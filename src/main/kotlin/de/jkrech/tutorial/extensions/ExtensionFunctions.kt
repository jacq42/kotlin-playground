package de.jkrech.tutorial.extensions

fun String.addSomething(): String {
    return "###: $this ###"
}

fun String?.lengthOrNull(): Int {
    return this?.length ?: 0
}