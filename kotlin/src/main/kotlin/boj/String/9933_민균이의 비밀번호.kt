package boj.String

fun main() {
    val n = readln().toInt()
    val arr = ArrayList<String>()
    repeat(n) {
        arr.add(readln())
    }

    for (s in arr) {
        var state = true
        for (i in 0 until (s.length / 2)) {
            if (s[i] != s[s.lastIndex - i]) {
                state = false
                break
            }
        }

        if (state) {
            print("${s.length} ")
            println(s[s.length/2])
            break
        } else {
            if (arr.contains(s.reversed())) {
                print("${s.length} ")
                println(s[s.length/2])
                break
            }
        }
    }
}