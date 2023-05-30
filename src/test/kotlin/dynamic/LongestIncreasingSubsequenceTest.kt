package dynamic

import org.junit.jupiter.api.Test

class LongestIncreasingSubsequenceTest {

    @Test
    fun lengthOfLIS() {
        with(LongestIncreasingSubsequence()) {
            test(intArrayOf(7, 7, 7, 7, 7, 7, 7), 1)
            test(intArrayOf(0, 1, 0, 3, 2, 3), 4)
            test(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18), 4)
        }
    }

    private fun LongestIncreasingSubsequence.test(nums: IntArray, result: Int) {
        val r = lengthOfLIS(nums)
        assert(r == result) { "Got $r" }
    }
}