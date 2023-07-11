package heap

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class IpoTest {
    @Test
    fun findMaximizedCapital() {
        with(Ipo()) {
            test(4, 2, 0, intArrayOf(1, 2, 3), intArrayOf(0, 1, 1))
            test(6, 3, 0, intArrayOf(1, 2, 3), intArrayOf(0, 1, 2))
        }
    }

    private fun Ipo.test(expected: Int, k: Int, w: Int, profits: IntArray, capital: IntArray) {
        assertEquals(expected, findMaximizedCapital(k, w, profits, capital))
    }
}