package boj.Data_Structures

import java.io.BufferedReader
import java.io.InputStreamReader

val enterSet = HashSet<String>()
var exitSet = HashSet<String>()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (s, e, q) = readLine().split(" ")
    while (true) {
        val str = readLine() ?: break
        val (time, name) = str.split(" ")
        if (time <= s) {
            enterSet.add(name)
        } else if (time in e..q) {
            exitSet.add(name)
        }
    }
    println(enterSet.intersect(exitSet).count())
}