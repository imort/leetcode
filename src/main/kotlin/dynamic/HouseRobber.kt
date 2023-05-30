package dynamic

import kotlin.math.max

class HouseRobber {
    fun rob(nums: IntArray): Int {
        var prev1 = 0
        var prev2 = 0
        for (num in nums) {
            prev2 = prev1.also { prev1 = max(prev2 + num, prev1) }
        }
        return prev1
    }
}