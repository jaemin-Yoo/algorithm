package boj.data_structures

/**
 * 문제 번호: (1043)
 * 문제 이름: (거짓말)
 * 소요 시간(분): (50)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val initTruePeople = readLine().split(" ").map { it.toInt() }
    val truePeople = BooleanArray(n + 1)
    val meetPeople = Array(n + 1) { mutableListOf<Int>() }
    val party = mutableListOf<List<Int>>()
    repeat(m) {
        val partyPeople = readLine().split(" ").map { it.toInt() }
        val people = partyPeople.subList(1, partyPeople.size)
        for (i in people.indices) {
            for (j in i + 1 until people.size) {
                val a = people[i]
                val b = people[j]
                meetPeople[a].add(b)
                meetPeople[b].add(a)
            }
        }
        party.add(people)
    }

    for (i in 1 until initTruePeople.size) {
        val person = initTruePeople[i]
        truePeople[person] = true
        dfs(person, truePeople, meetPeople)
    }

    var result = 0
    party.forEach { people ->
        if (!people.map { truePeople[it] }.contains(true)) {
            result += 1
        }
    }
    println(result)

    close()
}

private fun dfs(x: Int, truePeople: BooleanArray, meetPeople: Array<MutableList<Int>>) {
    meetPeople[x].forEach { a ->
        if (!truePeople[a]) {
            truePeople[a] = true
            dfs(a, truePeople, meetPeople)
        }
    }
}