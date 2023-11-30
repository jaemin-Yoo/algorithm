package boj.Greedy

fun main() {
    var t = 1
    while (true) {
        val s = readln()
        if ("-" in s) break

        val stack = mutableListOf<Char>()
        var changeCount = 0
        s.forEach {
            if (it == '{') {
                stack.add(it)
            } else {
                if (stack.isNotEmpty()) {
                    stack.removeLast()
                } else {
                    stack.add('{')
                    changeCount += 1
                }
            }
        }
        changeCount += stack.size / 2
        println("$t. $changeCount")
        t += 1
    }
}