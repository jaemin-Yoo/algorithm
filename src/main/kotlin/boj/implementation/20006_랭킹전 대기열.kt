package boj.implementation

/**
 * 문제 번호: (20006)
 * 문제 이름: (랭킹전 대기열)
 * 소요 시간(분): (x)
 */

data class Room(
    var isFull: Boolean,
    val range: Pair<Int, Int>,
    val players: MutableList<Pair<Int, String>>
)

fun main() = System.`in`.bufferedReader().use { br ->
    val (p, m) = br.readLine().split(' ').map { it.toInt() }
    val rooms = mutableListOf<Room>()
    repeat(p) {
        val (level, id) = br.readLine().split(' ').let { (a, b) -> a.toInt() to b }
        for (room in rooms) {
            val (a, b) = room.range
            if (!room.isFull && level in a..b) {
                room.players.add(level to id)
                if (room.players.size == m) {
                    room.isFull = true
                }
                return@repeat
            }
        }

        val newRoom = Room(
            isFull = m == 1,
            range = level - 10 to level + 10,
            players = mutableListOf(level to id)
        )
        rooms.add(newRoom)
    }

    val sb = StringBuilder()
    rooms.forEach { room ->
        if (room.isFull) {
            sb.appendLine("Started!")
        } else {
            sb.appendLine("Waiting!")
        }

        room.players.sortedWith(compareBy { it.second }).map { (level, id) ->
            sb.appendLine("$level $id")
        }
    }
    print(sb)
}