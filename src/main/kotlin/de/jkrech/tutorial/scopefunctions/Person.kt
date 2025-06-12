package de.jkrech.tutorial.scopefunctions

class Person(val name: String) {
    var age: Int = 0
    var city: String = ""

    override fun toString(): String {
        return "Person(name='$name', age=$age, city='$city')"
    }
}