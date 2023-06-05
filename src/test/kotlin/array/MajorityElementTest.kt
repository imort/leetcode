package array

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MajorityElementTest {
    @Test
    fun majorityElement() {
        with(MajorityElement()) {
            test(3, intArrayOf(3, 2, 3))
            test(2, intArrayOf(2, 2, 1, 1, 1, 2, 2))
            test(2, intArrayOf(1, 2, 3, 4, 5, 2, 2, 2, 2))
            test(2, intArrayOf(2, 2, 2, 2, 5, 4, 3, 1, 2))
        }
    }

    private fun MajorityElement.test(expected: Int, nums: IntArray) {
        assertEquals(expected, majorityElement(nums))
    }
}