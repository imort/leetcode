package array

class RemoveElement {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var count = 0
        nums.forEach {
            if (it != `val`) {
                nums[count] = it
                count++
            }
        }
        return count
    }
}