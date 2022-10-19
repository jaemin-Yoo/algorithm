package boj.Data_Structures

lateinit var arr: List<String>
val result = mutableSetOf<String>()
fun main() {
    arr = readln().map { it.toString() }
    for (i in arr.indices) {
        dfs(i, i, arr[i], arr[i])
    }

    println(result.count())
}

fun dfs(left: Int, right: Int, str: String, path: String) {

    if (left == 0 && right == arr.lastIndex) {
        result.add(path)
        return
    }

    if (left - 1 >= 0) {
        val s = arr[left - 1] + str
        dfs(left - 1, right, s, "$path $s")
    }

    if (right + 1 < arr.size) {
        val s = str + arr[right + 1]
        dfs(left, right + 1, s, "$path $s")
    }
}