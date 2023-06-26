package hashmap

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestConsecutiveSequenceTest {
    @Test
    fun longestConsecutive() {
        with(LongestConsecutiveSequence()) {
            test(4, intArrayOf(100, 4, 200, 1, 3, 2))
            test(9, intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1))
        }
    }

    private fun LongestConsecutiveSequence.test(expected: Int, nums: IntArray) {
        assertEquals(expected, longestConsecutive(nums))
    }
}