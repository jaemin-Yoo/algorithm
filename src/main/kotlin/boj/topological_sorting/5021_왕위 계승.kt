package boj.topological_sorting

/**
 * 문제 번호: (5021)
 * 문제 이름: (왕위 계승)
 * 소요 시간(분): (29)
 */

data class Profile(
    val value: Double?,
    val mom: String,
    val dad: String
)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = HashMap<String, Profile>()
    val root = readLine()
    map[root] = Profile(1.0, "", "")
    repeat(n) {
        val (child, mom, dad) = readLine().split(" ")
        map[child] = Profile(null, mom, dad)
    }

    var maxValue = 0.0
    var result = ""
    repeat(m) {
        val name = readLine()
        val value = getValue(map, name)
        if (maxValue < value) {
            maxValue = value
            result = name
        }
    }
    println(result)
    close()
}

private fun getValue(map: HashMap<String, Profile>, name: String): Double {
    return map[name]?.let { entry ->
        entry.value ?: (getValue(map, entry.mom) / 2 + getValue(map, entry.dad) / 2)
    } ?: 0.0
}