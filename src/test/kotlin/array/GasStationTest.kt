package array

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GasStationTest {
    @Test
    fun canCompleteCircuit() {
        with(GasStation()) {
            test(3, intArrayOf(1, 2, 3, 4, 5), intArrayOf(3, 4, 5, 1, 2))
            test(-1, intArrayOf(2, 3, 4), intArrayOf(3, 4, 3))
            test(4, intArrayOf(5, 1, 2, 3, 4), intArrayOf(4, 4, 1, 5, 1))
        }
    }

    private fun GasStation.test(expected: Int, gas: IntArray, cost: IntArray) {
        assertEquals(expected, canCompleteCircuit(gas, cost))
    }
}