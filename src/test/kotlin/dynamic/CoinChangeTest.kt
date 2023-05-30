package dynamic

import org.junit.jupiter.api.Test

class CoinChangeTest {

    @Test
    fun coinChange() {
        with(CoinChange()) {
            test(intArrayOf(186, 419, 83, 408), 6249, 20)
        }
    }

    private fun CoinChange.test(coins: IntArray, amount: Int, result: Int) {
        val change = coinChange(coins, amount)
        assert(change == result) { "Got $change" }
    }
}