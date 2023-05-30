package slidingwindow

import kotlin.math.min

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