package boj.카드게임4

class Solution {
    fun solution(coin: Int, cards: IntArray): Int {
        val n = cards.size
        val cardSum = n + 1
        val myCards = BooleanArray(n + 1)
        val shopCards = BooleanArray(n + 1)
        for (i in 0 until n / 3) {
            val card = cards[i]
            myCards[card] = true
        }

        var round = 1
        var nextRoundTicket = initNextRoundTicket(n, cardSum, myCards)
        var idx = n / 3
        var usedCoin = 0
        while (nextRoundTicket >= 0 && idx < n && usedCoin <= coin) {
            val card1 = cards[idx]
            val card2 = cards[idx + 1]
            shopCards[card1] = true
            shopCards[card2] = true

            if (nextRoundTicket == 0) {
                var state = false
                for (card in 1 until n + 1) {
                    val matchCard = cardSum - card
                    if (shopCards[card] && myCards[matchCard] && usedCoin + 1 <= coin) {
                        shopCards[card] = false
                        myCards[matchCard] = false
                        usedCoin += 1
                        nextRoundTicket += 1
                        state = true
                        break
                    }
                }
                if (!state) {
                    for(card in 1 until n + 1) {
                        val matchCard = cardSum - card
                        if (shopCards[card] && shopCards[matchCard] && usedCoin + 2 <= coin) {
                            shopCards[card] = false
                            shopCards[matchCard] = false
                            usedCoin += 2
                            nextRoundTicket += 1
                            break
                        }
                    }
                }

            }

            if (nextRoundTicket != 0) {
                round += 1
            }

            nextRoundTicket -= 1
            idx += 2
        }

        return round
    }

    private fun initNextRoundTicket(n: Int, cardSum: Int, myCards: BooleanArray): Int {
        var nextRoundTicket = 0
        for (card in 1 until n + 1) {
            val matchCard = cardSum - card
            if (myCards[card] && myCards[matchCard]) {
                myCards[card] = false
                myCards[matchCard] = false
                nextRoundTicket += 1
            }
        }
        return nextRoundTicket
    }
}