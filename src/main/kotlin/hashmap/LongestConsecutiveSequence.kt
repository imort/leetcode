package hashmap

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
class LongestConsecutiveSequence {
    fun longestConsecutive(nums: IntArray): Int {
        var maxLength = 0
        val numset = nums.toSet()
        for (num in nums) {
            if (num - 1 !in numset) {
                var length = 1
                while (numset.contains(num + length)) {
                    length += 1
                }
                maxLength = maxOf(maxLength, length)
            }
        }
        return maxLength
    }
}