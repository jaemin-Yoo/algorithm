fun main(args: Array<String>) {
    val (l, p) = readln().split(" ").map { it.toInt() }
    val members = readln().split(" ").map { it.toInt() }
    val s = l * p
    val result = members.map {
        it - s
    }
    println(result.joinToString(" "))
}
