package boj.Greedy

fun main() {
    val n = readln().toInt()
    val dice = readln().split(" ").map{ it.toLong() }
    val result = if (n == 1) {
        dice.sum() - dice.maxOrNull()!!
    } else {
        val threeSides = getMinThreeSides(dice) * 4
        val twoSides = getMinTwoSides(dice) * (8 * n - 12)
        val oneSide = getMinOneSide(dice) * (5 * n - 6) * (n - 2)
        oneSide + twoSides + threeSides
    }
    println(result)
}

fun getMinThreeSides(dice: List<Long>): Long {
    return listOf(
        dice[0] + dice[1] + dice[2],
        dice[0] + dice[1] + dice[3],
        dice[0] + dice[2] + dice[4],
        dice[0] + dice[3] + dice[4],
        dice[1] + dice[2] + dice[5],
        dice[1] + dice[3] + dice[5],
        dice[2] + dice[4] + dice[5],
        dice[3] + dice[4] + dice[5],
    ).minOrNull()!!
}

fun getMinTwoSides(dice: List<Long>): Long {
    return listOf(
        dice[0] + dice[1],
        dice[0] + dice[2],
        dice[0] + dice[3],
        dice[0] + dice[4],
        dice[1] + dice[2],
        dice[1] + dice[3],
        dice[1] + dice[5],
        dice[2] + dice[4],
        dice[2] + dice[5],
        dice[3] + dice[4],
        dice[3] + dice[5],
        dice[4] + dice[5],
    ).minOrNull()!!
}

fun getMinOneSide(dice: List<Long>): Long = dice.minOrNull()!!