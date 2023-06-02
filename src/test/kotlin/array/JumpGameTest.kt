package array

import org.junit.jupiter.api.Test

class JumpGameTest {
    @Test
    fun canJump() {
        with(JumpGame()) {
            test(intArrayOf(2, 3, 1, 1, 4), true)
            test(intArrayOf(2, 0, 0), true)
            test(intArrayOf(3, 2, 1, 0, 4), false)
            test(intArrayOf(0, 4, 4, 4, 4), false)
        }
    }

    private fun JumpGame.test(nums: IntArray, result: Boolean) {
        assert(canJump(nums) == result)
    }
}