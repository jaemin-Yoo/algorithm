package boj.Greedy

lateinit var arr: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val g = readLine().toInt()
    val p = readLine().toInt()
    arr = IntArray(g + 1) { i -> i }
    var cnt = 0
    run {
        repeat(p) {
            val i = readLine().toInt()
            val gi = find(i)
            if (gi == 0) return@run
            cnt += 1
            union(gi, gi - 1)
        }
    }
    println(cnt)
    close()
}

fun union(x: Int, y: Int) {
    var a = find(x)
    var b = find(y)
    if (a < b) {
        arr[y] = x
    } else if (a > b) {
        arr[x] = y
    }
}

fun find(x: Int): Int {
    return if (arr[x] == x) {
        x
    } else {
        find(arr[x]).also {
            arr[x] = it
        }
    }
}