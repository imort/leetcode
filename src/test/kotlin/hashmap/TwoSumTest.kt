package hashmap

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class TwoSumTest {
    @Test
    fun twoSum() {
        with(TwoSum()) {
            test(intArrayOf(0, 1), intArrayOf(2, 7, 11, 15), 9)
            test(intArrayOf(1, 2), intArrayOf(3, 2, 4), 6)
            test(intArrayOf(0, 1), intArrayOf(3, 3), 6)
        }
    }

    private fun TwoSum.test(expected: IntArray, nums: IntArray, target: Int) {
        assertContentEquals(expected, twoSum(nums, target))
    }
}