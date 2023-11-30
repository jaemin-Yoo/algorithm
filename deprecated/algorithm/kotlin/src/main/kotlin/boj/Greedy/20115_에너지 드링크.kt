package boj.Greedy.에너지드링크20115

fun main() {
    val n = readln().toInt()
    val drinkList = readln().split(" ").map { it.toDouble() }.sortedDescending()

    var result = drinkList[0]
    for (i in 1 until n) {
        result += drinkList[i] / 2
    }

    print(result)
}