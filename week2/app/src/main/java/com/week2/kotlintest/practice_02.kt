package com.week2.kotlintest
import java.util.Random

fun main() {
    var lotto = mutableListOf<Int>()
    val random = Random()

    for(i in 0..5) {
        lotto.add(random.nextInt(44) + 1)
    }
    println("${lotto}")
}