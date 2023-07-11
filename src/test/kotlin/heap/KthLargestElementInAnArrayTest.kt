package heap

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class KthLargestElementInAnArrayTest {
    @Test
    fun findKthLargest() {
        with(KthLargestElementInAnArray()) {
            test(5, intArrayOf(3,2,1,5,6,4), 2)
            test(4, intArrayOf(3,2,3,1,2,4,5,5,6), 4)
            test(1, intArrayOf(2, 1), 2)
        }
    }

    private fun KthLargestElementInAnArray.test(expected: Int, nums: IntArray, k: Int) {
        assertEquals(expected, findKthLargest(nums, k))
    }
}