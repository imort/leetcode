package array

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TrappingRainWaterTest {
    @Test
    fun trap() {
        with(TrappingRainWater()) {
            test(0, intArrayOf(0, 1))
            test(6, intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1))
            test(9, intArrayOf(4, 2, 0, 3, 2, 5))
        }
    }

    private fun TrappingRainWater.test(expected: Int, height: IntArray) {
        assertEquals(expected, trap(height))
    }
}