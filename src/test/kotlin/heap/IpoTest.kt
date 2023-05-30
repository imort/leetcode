package heap

import org.junit.jupiter.api.Test

class IpoTest {
    @Test
    fun findMaximizedCapital() {
        with(Ipo()) {
            test(2, 0, intArrayOf(1, 2, 3), intArrayOf(0, 1, 1), 4)
        }
    }

    private fun Ipo.test(k: Int, w: Int, profits: IntArray, capital: IntArray, result: Int) {
        val r = findMaximizedCapital(k, w, profits, capital)
        assert(r == result) { "Got $r" }
    }
}