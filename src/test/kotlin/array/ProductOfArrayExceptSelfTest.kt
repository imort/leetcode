package array

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ProductOfArrayExceptSelfTest {
    @Test
    fun productExceptSelf() {
        with(ProductOfArrayExceptSelf()) {
            test(intArrayOf(24, 12, 8, 6), intArrayOf(1, 2, 3, 4))
            test(intArrayOf(0, 0, 9, 0, 0), intArrayOf(-1, 1, 0, -3, 3))
        }
    }

    private fun ProductOfArrayExceptSelf.test(expected: IntArray, nums: IntArray) {
        assertArrayEquals(expected, productExceptSelf(nums))
    }
}