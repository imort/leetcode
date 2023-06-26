package hashmap

/**
 * Given an integer array nums and an integer k,
 * return true if there are two distinct indices i and j in the array
 * such that nums[i] == nums[j] and abs(i - j) <= k.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 */
class ContainsDuplicate2 {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        if (k == 0) return false
        val set = LinkedHashSet<Int>(k)
        for (num in nums) {
            if (set.contains(num)) return true
            if (set.size == k) set -= set.first()
            set += num
        }
        return false
    }
}