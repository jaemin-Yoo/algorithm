package programmers.KI2019.불량사용자

// 1시간

class Solution {

    private val caseList = mutableListOf<List<String>>()

    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {

        dfs(0, mutableListOf(), user_id, banned_id)

        val newList = caseList.map { case ->
            case.sorted().joinToString(" ")
        }.distinct()

        return newList.size
    }

    private fun dfs(bannedIdx: Int, idList: MutableList<String>, user_id: Array<String>, banned_id: Array<String>) {
        if (bannedIdx == banned_id.size) {
            caseList.add(idList.toList())
            return
        }

        for (userId in user_id) {
            val bannedId = banned_id[bannedIdx]

            if (userId in idList) continue
            if (isSameId(userId, bannedId)) {
                idList.add(userId)
                dfs(bannedIdx + 1, idList, user_id, banned_id)
                idList.removeLast()
            }
        }
    }

    private fun isSameId(userId: String, bannedId: String): Boolean {
        if (userId.length != bannedId.length) {
            return false
        }

        for (i in userId.indices) {
            if (bannedId[i] == '*') {
                continue
            }

            if (bannedId[i] != userId[i]) {
                return false
            }
        }

        return true
    }
}