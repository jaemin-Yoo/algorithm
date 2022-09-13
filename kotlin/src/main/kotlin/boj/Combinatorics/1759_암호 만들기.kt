package boj.Combinatorics

class 암호만들기1759 {
    lateinit var alphaList: List<Int>
    val vowels = listOf('a'.code, 'e'.code, 'i'.code, 'o'.code, 'u'.code)

    fun main() {
        val (l, c) = readln().split(" ").map { it.toInt() }
        alphaList = readln().split(" ").map { it.first().code }.sorted()
        solve(l, c, 0, mutableListOf())
    }

    fun solve(n: Int, m: Int, start: Int, list: MutableList<Int>) {
        if (n == list.size) {
            var vCnt = 0
            var cCnt = 0
            for (c in list) {
                if (c in vowels) {
                    vCnt += 1
                } else {
                    cCnt += 1
                }
            }
            if (vCnt == 0 || cCnt < 2) return

            println(list.joinToString("") { it.toChar().toString() })
            return
        }

        for (i in start until m) {
            list.add(alphaList[i])
            solve(n, m, i + 1, list)
            list.removeLast()
        }
    }
}