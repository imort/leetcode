package twopointers

import java.util.*

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 */
class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableListOf<List<Int>>()
        val size = nums.size
        for (i in 0 until size - 2) {
            val first = nums[i]
            if (i == 0 || first != nums[i - 1]) {
                val target = -first
                var start = i + 1
                var end = nums.lastIndex

                fun skipStart(distinctFrom: Int) {
                    do start++ while (start < size && nums[start] == distinctFrom)
                }

                fun skipEnd(distinctFrom: Int) {
                    do end-- while (end >= 0 && nums[end] == distinctFrom)
                }

                while (start < end) {
                    val second = nums[start]
                    val third = nums[end]
                    val pick = second + third
                    when {
                        pick < target -> skipStart(second)
                        pick > target -> skipEnd(third)
                        else -> result.add(listOf(first, second, third)).also { skipStart(second) }
                    }
                }
            }
        }
        return result
    }
}