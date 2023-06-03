package array

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 */
class RotateArray {
    fun rotate(nums: IntArray, k: Int) {
        val n = nums.size
        if (n == 0) return
        val rotate = k % n
        val breakIndex = nums.size - rotate
        nums.reverse(0, breakIndex)
        nums.reverse(breakIndex, nums.size)
        nums.reverse(0, nums.size)
    }

//    private fun IntArray.reverse(fromIndex: Int, toIndex: Int) {
//        val midPoint = (fromIndex + toIndex) / 2
//        if (fromIndex == midPoint) return
//        var reverseIndex = toIndex - 1
//        for (index in fromIndex until midPoint) {
//            val tmp = this[index]
//            this[index] = this[reverseIndex]
//            this[reverseIndex] = tmp
//            reverseIndex--
//        }
//    }
}