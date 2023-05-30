package array

class RemoveDuplicatesFromSortedArray {
    fun removeDuplicates(nums: IntArray): Int {
        var count = 0
        var current = Integer.MIN_VALUE
        nums.forEach {
            if (it != current) {
                nums[count] = it
                current = it
                count++
            }
        }
        return count
    }
}