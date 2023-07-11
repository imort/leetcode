package intervals

/**
 * You are given a sorted unique integer array nums.
 * A range [a,b] is the set of all integers from a to b (inclusive).
 *
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
 * That is, each element of nums is covered by exactly one of the ranges,
 * and there is no integer x such that x is in one of the ranges but not in nums.
 *
 * Each range [a,b] in the list should be output as:
 *
 * "a->b" if a != b
 * "a" if a == b
 */
class SummaryRanges {
    fun summaryRanges(nums: IntArray): List<String> {
        if (nums.isEmpty()) return emptyList()
        val result = mutableListOf<String>()
        var start = 0
        for (i in 1..nums.lastIndex) {
            val curr = nums[i]
            val prev = nums[i - 1]
            if (curr != prev + 1) {
                result += if (i - 1 == start) {
                    "${nums[start]}"
                } else {
                    "${nums[start]}->$prev"
                }
                start = i
            }
        }
        result += if (nums.lastIndex == start) {
            "${nums[start]}"
        } else {
            "${nums[start]}->${nums[nums.lastIndex]}"
        }
        return result
    }
}