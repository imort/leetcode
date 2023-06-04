package array

import kotlin.math.max

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 */
class TrappingRainWater {
    fun trap(height: IntArray): Int {
        if (height.size <= 2) return 0
        var left = 0
        var leftMax = height[left]
        var right = height.lastIndex
        var rightMax = height[right]
        var water = 0
        while (left < right) {
            val leftHeight = height[left]
            val rightHeight = height[right]
            if (leftHeight < rightHeight) {
                leftMax = max(leftMax, leftHeight)
                water += leftMax - leftHeight
                left++
            } else {
                rightMax = max(rightMax, rightHeight)
                water += rightMax - rightHeight
                right--
            }
        }
        return water
    }
}