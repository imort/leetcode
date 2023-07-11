package dynamic

import kotlin.math.max

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected,
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 */
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