package array

import kotlin.math.max

class BestTimeToBuyAndSellStock {
    fun maxProfit(prices: IntArray): Int {
        var min = prices[0]
        var max = 0
        for (i in 1 until prices.size) {
            val price = prices[i]
            if (price < min) min = price else max = max(max, price - min)
        }
        return max
    }
}