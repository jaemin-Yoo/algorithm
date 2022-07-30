package boj.String

val numArr = listOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
fun main() {
    val (m, n) = readLine()!!.split(' ').map { it.toInt() }
    val arr = arrayListOf<String>()
    for (num in m..n) {
        val strNum = num.toString().map {
            numArr[it.toString().toInt()]
        }.joinToString(" ")
        arr.add(strNum)
    }

    val intArr = arr.sorted().map { strNum ->
        var num = ""
        strNum.split(' ').map { str ->
            num += numArr.indexOf(str)
        }
        num.toInt()
    }

    for (i in intArr.indices) {
        if ((i+1) % 10 == 0 || i == intArr.lastIndex) println(intArr[i]) else print("${intArr[i]} ")
    }
}