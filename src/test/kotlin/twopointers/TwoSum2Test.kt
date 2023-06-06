package twopointers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TwoSum2Test {
    @Test
    fun twoSum() {
        with(TwoSum2()) {
            test(intArrayOf(1, 2), intArrayOf(2, 7, 11, 15), 9)
            test(intArrayOf(1, 3), intArrayOf(2, 3, 4), 6)
            test(intArrayOf(1, 2), intArrayOf(-1, 0), -1)
        }
    }

    private fun TwoSum2.test(expected: IntArray, nums: IntArray, target: Int) {
        assertArrayEquals(expected, twoSum(nums, target))
    }
}