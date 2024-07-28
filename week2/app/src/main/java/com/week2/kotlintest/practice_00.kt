package com.week2.kotlintest

fun main() {
    var sum : Int = 0

    for(i in 1..5) {
        print("Enter a number: ")
        sum += readLine()!!.toInt()
    }
    println("sum: $sum, average: ${sum/5}")
}