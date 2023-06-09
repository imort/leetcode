package intervals

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class InsertIntervalTest {
    @Test
    fun insert() {
        with(InsertInterval()) {
            test(
                arrayOf(intArrayOf(1, 5), intArrayOf(6, 9)),
                arrayOf(intArrayOf(1, 3), intArrayOf(6, 9)),
                intArrayOf(2, 5),
            )
            test(
                arrayOf(intArrayOf(1, 2), intArrayOf(3, 10), intArrayOf(12, 16)),
                arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7), intArrayOf(8, 10), intArrayOf(12, 16)),
                intArrayOf(4, 8),
            )
            test(
                arrayOf(intArrayOf(5, 7)),
                arrayOf(),
                intArrayOf(5, 7),
            )
            test(
                arrayOf(intArrayOf(1, 7)),
                arrayOf(intArrayOf(1, 5)),
                intArrayOf(2, 7),
            )
            test(
                arrayOf(intArrayOf(3, 5), intArrayOf(6, 6), intArrayOf(12, 15)),
                arrayOf(intArrayOf(3, 5), intArrayOf(12, 15)),
                intArrayOf(6, 6),
            )
        }
    }

    private fun InsertInterval.test(
        expected: Array<IntArray>,
        intervals: Array<IntArray>,
        newInterval: IntArray,
    ) {
        assertArrayEquals(expected, insert(intervals, newInterval))
    }
}