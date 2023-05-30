package dynamic

import kotlin.math.min

class CoinChange {
    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount == 0) return 0
        val counts = IntArray(amount + 1) { -1 }
        counts[amount] = 0
        for (i in amount downTo 0) {
            if (counts[i] < 0) continue
            for (coin in coins) {
                val next = i - coin
                if (next < 0) continue
                counts[next] = if (counts[next] < 0) counts[i] + 1 else min(counts[next], counts[i] + 1)
            }
        }
        return counts[0]
    }
}