package com.week2.kotlintest
import kotlin.math.pow

fun main() {
    val weight : Int
    val height : Int

    print("키를 입력하시오. (cm 단위): ")
    height = readLine()!!.toInt()
    print("몸무게를 입력하시오. (kg 단위): ")
    weight = readLine()!!.toInt()

    val BMI = weight.toFloat() / (height.toFloat() / 100.0).pow(2)

    val obesity : String = when(BMI) {
        in 0.0..18.5 -> "저체중"
        in 18.6..23.0 -> "정상"
        in 23.1..25.0 -> "과체중"
        else -> "비만"
    }
    println("키 $height cm, 몸무게 $weight kg의 BMI 지수는 ${BMI.toFloat()} 이며 $obesity 입니다.")
}