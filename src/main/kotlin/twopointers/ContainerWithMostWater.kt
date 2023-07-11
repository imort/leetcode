package twopointers

/**
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 */
class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        if (height.isEmpty() || height.size == 1) return 0
        var left = 0
        var right = height.lastIndex
        var maxArea = 0
        while (left < right) {
            val width = right - left
            val area = if (height[left] < height[right]) {
                (height[left] * width).also { left++ }
            } else {
                (height[right] * width).also { right-- }
            }
            if (area > maxArea) maxArea = area
        }
        return maxArea
    }
}