package programmers.KI2020.수식최대화

// 1시간 33분

import kotlin.math.max
import kotlin.math.abs

class Solution {

    private val operatorPriorityList = listOf(
        listOf('+', '-', '*'),
        listOf('+', '*', '-'),
        listOf('-', '+', '*'),
        listOf('-', '*', '+'),
        listOf('*', '+', '-'),
        listOf('*', '-', '+')
    )

    fun solution(expression: String): Long {
        var result = 0L
        for (priorityList in operatorPriorityList) {
            val (numberList, optList) = splitExpression(expression)
            for (opt in priorityList) {
                updateListAfterCalculate(opt, numberList, optList)
            }
            val exp = numberList[0]
            result = max(result, abs(exp))
        }

        return result
    }

    private fun splitExpression(expression: String): Pair<MutableList<Long>, MutableList<Char>> {
        var number = ""
        val numberList = mutableListOf<Long>()
        val optList = mutableListOf<Char>()
        for (i in expression.indices) {
            if (expression[i] in operatorPriorityList[0]) {
                optList.add(expression[i])
                numberList.add(number.toLong())
                number = ""
            } else {
                number += expression[i]
            }
        }
        numberList.add(number.toLong())

        return numberList to optList
    }

    private fun updateListAfterCalculate(opt: Char, numberList: MutableList<Long>, optList: MutableList<Char>) {
        val removeOptIndex = mutableListOf<Int>()
        val removeNumberIndex = mutableListOf<Int>()
        for (i in optList.indices) {
            if (optList[i] == opt) {
                val result = calculate(opt, numberList[i], numberList[i + 1])
                numberList[i + 1] = result
                removeOptIndex.add(i)
                removeNumberIndex.add(i)
            }
        }

        removeOptIndex.sortedDescending().forEach {
            optList.removeAt(it)
        }
        removeNumberIndex.sortedDescending().forEach {
            numberList.removeAt(it)
        }
    }

    private fun calculate(opt: Char, num1: Long, num2: Long): Long {
        return when (opt) {
            '+' -> num1 + num2
            '-' -> num1 - num2
            '*' -> num1 * num2
            else -> throw Exception("No operator")
        }
    }
}