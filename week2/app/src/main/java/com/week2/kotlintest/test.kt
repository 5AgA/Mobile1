package com.week2.kotlintest

fun main()  {
    println("Hello World!")

    val numbers = Array<Int>(5) { readLine()!!.toInt()}

    var total : Int = 0
    for(number in numbers) {
        total += number
    }
    println("총합: $total 평균: ${total.toFloat()/5}")
}