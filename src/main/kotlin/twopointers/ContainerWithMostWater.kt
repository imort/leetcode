package twopointers

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