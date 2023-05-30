package array

import org.junit.jupiter.api.Test

class BestTimeToBuyAndSellStock2Test {

    @Test
    fun maxProfit() {
        with(BestTimeToBuyAndSellStock2()) {
            test(intArrayOf(7, 1, 5, 3, 6, 4), 7)
        }
    }

    private fun BestTimeToBuyAndSellStock2.test(prices: IntArray, result: Int) {
        val r = maxProfit(prices)
        assert(r == result) { "Got $r" }
    }
}