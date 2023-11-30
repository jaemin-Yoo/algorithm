package programmers.KAKAOTECHINTERNSHIP2022.두큐합같게만들기

import java.util.Queue
import java.util.LinkedList

class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val q1: Queue<Long> = LinkedList()
        val q2: Queue<Long> = LinkedList()
        queue1.forEach {
            q1.add(it.toLong())
        }
        queue2.forEach {
            q2.add(it.toLong())
        }
        var q1Sum = q1.sum()
        var q2Sum = q2.sum()
        var cnt = 0
        while (true) {
            if (cnt > queue1.size * 4) {
                cnt = -1
                break
            }

            if (q1Sum > q2Sum) {
                val v = q1.poll()
                q1Sum -= v
                q2Sum += v
                q2.add(v)
            } else if (q1Sum < q2Sum){
                val v = q2.poll()
                q1Sum += v
                q2Sum -= v
                q1.add(v)
            } else {
                break
            }
            cnt += 1
        }
        return cnt
    }
}