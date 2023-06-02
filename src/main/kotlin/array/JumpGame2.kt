package array

import kotlin.math.min

/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words,
 * if you are at nums[i], you can jump to any nums[i + j] where:
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1].
 * The test cases are generated such that you can reach nums[n - 1].
 */
class JumpGame2 {
    fun jump(nums: IntArray): Int {
        val jumps = IntArray(nums.size) { Integer.MAX_VALUE }.apply {
            this[0] = 0
        }
        val last = jumps.lastIndex
        for (i in 0 until last) {
            val jumpCounter = jumps[i] + 1
            val end = (i + nums[i]).coerceAtMost(last)
            for (j in i + 1..end) {
                jumps[j] = min(jumps[j], jumpCounter)
            }
        }
        return jumps[last]
    }
}