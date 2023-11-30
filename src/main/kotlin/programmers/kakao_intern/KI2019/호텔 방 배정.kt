package programmers.KI2019.호텔방배정

// 못품

class Solution {
    fun solution(k: Long, room_number: LongArray): LongArray {
        val hashMap = HashMap<Long, Long>()
        val result = LongArray(room_number.size)
        for (i in room_number.indices) {
            val roomNumber = room_number[i]
            result[i] = findEmptyRoom(hashMap, roomNumber)
        }

        return result
    }

    private fun findEmptyRoom(hashMap: HashMap<Long, Long>, roomNumber: Long): Long {
        val number = if (hashMap.containsKey(roomNumber)) {
            findEmptyRoom(hashMap, hashMap[roomNumber]!!)
        } else {
            roomNumber
        }

        hashMap[roomNumber] = number + 1
        return number
    }
}