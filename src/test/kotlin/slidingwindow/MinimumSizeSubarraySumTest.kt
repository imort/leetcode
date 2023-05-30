package slidingwindow

import org.junit.jupiter.api.Test

class MinimumSizeSubarraySumTest {
    @Test
    fun test() {
        val test = MinimumSizeSubarraySum()
        assert(test.minSubArrayLen(7, intArrayOf(1, 2, 3, 4, 6)) == 2)
    }
}
