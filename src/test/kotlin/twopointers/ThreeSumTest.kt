package twopointers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ThreeSumTest {
    @Test
    fun threeSum() {
        with(ThreeSum()) {
            test(listOf(listOf(-1, -1, 2), listOf(-1, 0, 1)), intArrayOf(-1, 0, 1, 2, -1, -4))
            test(listOf(), intArrayOf(0, 1, 1))
            test(listOf(listOf(0, 0, 0)), intArrayOf(0, 0, 0))
        }
    }

    private fun ThreeSum.test(expected: List<List<Int>>, nums: IntArray) {
        assertEquals(expected, threeSum(nums))
    }
}