package array

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than n / 2 times.
 * You may assume that the majority element always exists in the array.
 */
class MajorityElement {
    fun majorityElement(nums: IntArray): Int {
        var count = 0
        var curr = 0
        nums.forEach { num ->
            when {
                count == 0 -> {
                    curr = num
                    count = 1
                }

                num == curr -> {
                    count += 1
                }

                else -> {
                    count -= 1
                }
            }
        }
        return curr
    }
}