package com.week3.myapplication

import java.text.SimpleDateFormat
import java.util.Calendar
import kotlin.math.abs

data class RegDate(val year: Int, val month: Int, val day: Int) {
    override fun toString(): String {
        return "${this.year}-${this.month}-${this.day}"
    }
}

data class Address(val city: String, val dong: String, val addrNo: String)

class Member(val name: String, val regDate: RegDate, val address: Address) {
    fun getShippingCost(): Int {
        return if (address.city == "seoul") {
            3000
        } else {
            4000
        }
    }

    fun getTerm(year: Int, month: Int): String {
        val diffMonth = (year - this.regDate.year) * 12 + abs(month - this.regDate.month)
        if( diffMonth > 24 )
            return "long-term"
        else
            return "short-term"
    }
}

fun getPeriod(member: Member): Int {
    var today = Calendar.getInstance()
    var startDate = "${member.regDate}"
    var sf = SimpleDateFormat("yyyy-MM-dd")
    var date = sf.parse(startDate)

    var calcuDate = (today.time.time - date.time) / (60 * 60 * 24 * 1000)
    return calcuDate.toInt()
}

fun main() {
    var today = Calendar.getInstance()
    val year = today.get(Calendar.YEAR)
    val month = today.get(Calendar.MONTH)
    val regDate = RegDate(2022, 1, 15)
    val address = Address("seoul", "mok", "713-15")
    val member = Member("Euna", regDate, address)

    println("Name: ${member.name}")
    println("Registration Date: $regDate")
    println("Address: $address")
    println("Shipping Cost: ${member.getShippingCost()}")
    println("Term: ${member.getTerm(year, month)}")

    val period = getPeriod(member)
    println("Days since registration: ${getPeriod(member)}")
}