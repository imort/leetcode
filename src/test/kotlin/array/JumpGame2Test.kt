package array

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class JumpGame2Test {
    @Test
    fun jump() {
        with(JumpGame2()) {
            test(2, intArrayOf(2, 3, 1, 1, 4))
            test(1, intArrayOf(2, 0, 0))
            test(2, intArrayOf(3, 3, 1, 0, 4))
            test(4, intArrayOf(1, 1, 1, 1, 4))
        }
    }

    private fun JumpGame2.test(result: Int, nums: IntArray) {
        assertEquals(result, jump(nums))
    }
}