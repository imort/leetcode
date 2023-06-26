package hashmap

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ContainsDuplicate2Test {
    @Test
    fun containsNearbyDuplicate() {
        with(ContainsDuplicate2()) {
            test(true, intArrayOf(1, 2, 3, 1), 3)
            test(true, intArrayOf(1, 0, 1, 1), 1)
            test(false, intArrayOf(1, 2, 3, 1, 2, 3), 2)
        }
    }

    private fun ContainsDuplicate2.test(expected: Boolean, nums: IntArray, k: Int) {
        assertEquals(expected, containsNearbyDuplicate(nums, k))
    }
}