package array

import kotlin.math.max

/**
 * You are given an integer array nums. You are initially positioned
 * at the array's first index, and each element in the array represents
 * your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 */
class JumpGame {
    fun canJump(nums: IntArray): Boolean {
        if (nums.isEmpty()) return false
        if (nums.size == 1) return true
        val end = nums.lastIndex
        var max = nums[0]
        for (i in 1..end) {
            if (i <= max) {
                max = max(max, i + nums[i])
            } else {
                break
            }
        }
        return max >= end
    }
}