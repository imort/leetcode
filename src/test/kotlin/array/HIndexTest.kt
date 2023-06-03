package array

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HIndexTest {
    @Test
    fun hIndex() {
        with(HIndex()) {
            test(3, intArrayOf(3, 0, 6, 1, 5))
            test(1, intArrayOf(1, 3, 1))
        }
    }

    private fun HIndex.test(expected: Int, citations: IntArray) {
        assertEquals(expected, hIndex(citations))
    }
}