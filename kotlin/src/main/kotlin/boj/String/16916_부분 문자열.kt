package boj.String

fun main() {
    val s = readln()
    val p = readln()
    print(KMP(s, p))
}

fun makeTable(pattern: String) : IntArray {
    val patternSize = pattern.length
    val table = IntArray(patternSize) { 0 }
    var j = 0
    for (i in 1 until patternSize) {
        while (j > 0 && pattern[i] != pattern[j]) {
            j = table[j-1]
        }

        if (pattern[i] == pattern[j]) {
            table[i] = ++j
        }
    }
    return table
}

fun KMP(parent: String, pattern: String) : Int {
    val table = makeTable(pattern)
    val patternSize = pattern.length
    var j = 0
    for (i in parent.indices) {
        while (j > 0 && parent[i] != pattern[j]) {
            j = table[j-1]
        }

        if (parent[i] == pattern[j]) {
            if (j == patternSize - 1) {
                return 1
            } else {
                j ++
            }
        }
    }
    return 0
}