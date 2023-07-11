package dynamic

import kotlin.math.max

/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence
 */
class LongestIncreasingSubsequence {
    fun lengthOfLIS(nums: IntArray): Int {
        val lengths = IntArray(nums.size)
        lengths[lengths.lastIndex] = 1
        for (i in lengths.lastIndex - 1 downTo 0) {
            var max = 0
            for (j in i + 1..lengths.lastIndex) {
                if (nums[j] > nums[i]) max = max(max, lengths[j])
            }
            lengths[i] = 1 + max
        }
        return lengths.max()
    }
}