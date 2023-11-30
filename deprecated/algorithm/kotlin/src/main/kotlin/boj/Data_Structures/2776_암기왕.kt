package boj.Data_Structures

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val t = readLine().toInt()
    repeat(t) {
        val n = readLine().toInt()
        val note1 = readLine().split(" ").map { it.toInt() }
        val m = readLine().toInt()
        val note2 = readLine().split(" ").map { it.toInt() }

        val map = HashMap<Int, Int>()
        note2.forEach {
            map[it] = 0
        }

        note1.forEach {
            map[it] = 1
        }

        val sb = StringBuilder()
        for (i in note2.indices) {
            if (i == note2.lastIndex) {
                sb.append(map[note2[i]]!!.toString())
            } else {
                sb.append(map[note2[i]]!!.toString() + "\n")
            }
        }
        println(sb.toString())
    }
}