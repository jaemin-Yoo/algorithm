package boj.Greedy.물병1052

fun main() {
    val (n, k) = readln().split(" ").map{ it.toInt() }
    var initValue = n
    var m = initValue
    var cnt = 0
    var result = 0
    while (true) {
        val qt = m / 2
        val rm = m % 2
        cnt += rm
        if (qt + cnt <= k) {
            break
        }

        if (cnt > k) {
            initValue += 1
            m = initValue
            cnt = 0
            result += 1
        } else {
            m = qt
        }
    }
    println(result)
}

/*

1015808 5

15 - 1
7 - 1
3 - 1
1 -1

몫 + 나머지 <= k : 성공
나머지가 있을 때 : 처음 값에 +1 해서 다시 작업

 */