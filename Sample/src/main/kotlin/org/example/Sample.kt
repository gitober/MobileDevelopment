package org.example

fun main() {
    val sample = Sample()
    println(sample.sum(1, 2))
}

class Sample {

    fun sum(a: Int, b: Int): Int {
        return a + b
    }
}
