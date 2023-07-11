package dynamic

import kotlin.math.min

/**
 * You are given an integer array coins representing coins of different denominations
 * and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Constraints:
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
class CoinChange {
    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount == 0) return 0
        val counts = IntArray(amount + 1) { -1 }
        counts[amount] = 0
        for (i in amount downTo 0) {
            if (counts[i] < 0) continue
            for (coin in coins) {
                val index = i - coin
                if (index < 0) continue
                counts[index] = if (counts[index] < 0) counts[i] + 1 else min(counts[index], counts[i] + 1)
            }
        }
        return counts[0]
    }
}