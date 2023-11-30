package boj.String

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val arr = Array(m) { ArrayList<Char>() }
    repeat(n) {
        val dna = readln()
        for (i in dna.indices) {
            arr[i].add(dna[i])
        }
    }

    var dist = 0
    var result = ""
    arr.forEach { row ->
        var maxCnt = 0
        var temp = ""
        row.sorted().distinct().forEach { c ->
            val cnt = row.count { it == c }
            if (maxCnt < cnt) {
                maxCnt = cnt
                temp = c.toString()
            }
        }
        dist += row.count { it.toString() != temp }
        result += temp
    }
    println(result)
    println(dist)
}