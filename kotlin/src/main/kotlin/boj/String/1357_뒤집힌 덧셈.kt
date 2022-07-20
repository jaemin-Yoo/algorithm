package boj.String

fun main() {
    val (x, y) = readLine()!!.split(' ')

    var xT = ""
    for (i in x) xT = i + xT

    var yT = ""
    for (i in y) yT = i + yT

    val z = (xT.toInt() + yT.toInt()).toString()
    var zT = ""
    for (i in z) zT = i + zT

    println(zT.toInt())
}