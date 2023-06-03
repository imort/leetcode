package array

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class RotateArrayTest {
    @Test
    fun rotate() {
        with(RotateArray()) {
            test(intArrayOf(5, 6, 7, 1, 2, 3, 4), intArrayOf(1, 2, 3, 4, 5, 6, 7), 3)
            test(intArrayOf(3, 4, 1, 2), intArrayOf(1, 2, 3, 4), 2)
        }
    }

    private fun RotateArray.test(expected: IntArray, nums: IntArray, k: Int) {
        rotate(nums, k)
        assertArrayEquals(expected, nums)
    }
}