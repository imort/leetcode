package slidingwindow

import kotlin.math.min

/**
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a subarray whose sum is greater than or equal to target.
 * If there is no such subarray, return 0 instead.
 */
class MinimumSizeSubarraySum {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var minLength = Integer.MAX_VALUE
        var start = 0
        var sum = 0
        for (index in nums.indices) {
            sum += nums[index]
            while (sum >= target) {
                minLength = min(minLength, index - start + 1)
                sum -= nums[start++]
            }
        }
        return if (minLength == Int.MAX_VALUE) 0 else minLength
    }
}