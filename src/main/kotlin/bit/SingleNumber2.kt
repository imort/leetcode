package bit

/**
 * Given an integer array nums where every element appears three times except for one, which appears exactly once.
 * Find the single element and return it.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
class SingleNumber2 {
    fun singleNumber(nums: IntArray): Int {
        var once = 0
        var twice = 0
        nums.forEach { num ->
            once = once.xor(num) and twice.inv()
            twice = twice.xor(num) and once.inv()
        }
        return once
    }
}