package intervals

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinArrowsToBurstBalloonsTest {
    @Test
    fun findMinArrowShots() {
        with(MinArrowsToBurstBalloons()) {
            test(
                2,
                arrayOf(
                    intArrayOf(10, 16),
                    intArrayOf(2, 8),
                    intArrayOf(1, 6),
                    intArrayOf(7, 12),
                )
            )
            test(
                4,
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 4),
                    intArrayOf(5, 6),
                    intArrayOf(7, 8),
                )
            )
            test(
                2,
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(3, 4),
                    intArrayOf(4, 5),
                )
            )
        }
    }

    private fun MinArrowsToBurstBalloons.test(expected: Int, points: Array<IntArray>) {
        assertEquals(expected, findMinArrowShots(points))
    }
}