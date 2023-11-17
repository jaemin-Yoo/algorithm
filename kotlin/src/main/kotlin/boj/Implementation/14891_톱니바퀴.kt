package boj.Implementation.톱니바퀴14891

private const val ROTATE_LEFT = -1
private const val ROTATE_RIGHT = 1

private lateinit var t1: MutableList<Char>
private lateinit var t2: MutableList<Char>
private lateinit var t3: MutableList<Char>
private lateinit var t4: MutableList<Char>

fun main() = with(System.`in`.bufferedReader()) {
    t1 = readLine().toMutableList()
    t2 = readLine().toMutableList()
    t3 = readLine().toMutableList()
    t4 = readLine().toMutableList()
    val k = readLine().toInt()
    val combState = BooleanArray(3)
    repeat(k) {
        val (n, d) = readLine().split(" ").map { it.toInt() }
        checkMoveState(t1, t2, t3, t4, combState)
        spread(n, d, combState)
    }

    val result = score(1, t1) + score(2, t2) + score(3, t3) + score(4, t4)
    println(result)
    close()
}

private fun spread(num: Int, direction: Int, combState: BooleanArray) {
    moveGear(num, direction)

    var d = direction
    for (i in num - 1 until 3) {
        if (!combState[i]) break

        d *= -1
        moveGear(i + 2, d)
    }

    d = direction
    for (i in num - 2 downTo 0) {
        if (!combState[i]) break

        d *= -1
        moveGear(i + 1, d)
    }
}

private fun moveGear(num: Int, direction: Int) {
    val t = when (num) {
        1 -> t1
        2 -> t2
        3 -> t3
        4 -> t4
        else -> mutableListOf()
    }

    when (direction) {
        ROTATE_LEFT -> {
            val a = t.removeFirst()
            t.add(a)
        }
        ROTATE_RIGHT -> {
            val a = t.removeLast()
            t.add(0, a)
        }
        else -> {}
    }
}

private fun checkMoveState(t1: MutableList<Char>, t2: MutableList<Char>, t3: MutableList<Char>, t4: MutableList<Char>, combState: BooleanArray) {
    combState[0] = t1[2] != t2[6]
    combState[1] = t2[2] != t3[6]
    combState[2] = t3[2] != t4[6]
}

private fun score(num: Int, t: MutableList<Char>): Int {
    if (t[0] == '0') return 0

    return when (num) {
        1 -> 1
        2 -> 2
        3 -> 4
        4 -> 8
        else -> 0
    }
}