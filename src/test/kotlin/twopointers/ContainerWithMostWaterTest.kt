package twopointers

import org.junit.jupiter.api.Test

class ContainerWithMostWaterTest {
    @Test
    fun maxArea() {
        val test = ContainerWithMostWater()
        assert(test.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)) == 49)
    }
}