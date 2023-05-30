package intervals

import org.junit.jupiter.api.Test

class MergeIntervalsTest {

    @Test
    fun merge() {
        with(MergeIntervals()) {
            test(
                arrayOf(
                    intArrayOf(1, 4),
                    intArrayOf(4, 5),
                ),
                arrayOf(
                    intArrayOf(1, 5),
                ),
            )
            test(
                arrayOf(
                    intArrayOf(15, 18),
                    intArrayOf(1, 3),
                    intArrayOf(2, 6),
                    intArrayOf(8, 10),
                ),
                arrayOf(
                    intArrayOf(1, 6),
                    intArrayOf(8, 10),
                    intArrayOf(15, 18),
                ),
            )
        }
    }

    private fun MergeIntervals.test(intervals: Array<IntArray>, result: Array<IntArray>) {
        val r = merge(intervals)
        assert(r.contentDeepEquals(result)) {
            "Got ${r.joinToString(prefix = "[", postfix = "]") { it.joinToString() }}"
        }
    }
}