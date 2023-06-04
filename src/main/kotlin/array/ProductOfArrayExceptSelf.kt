package array

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product
 * of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */
class ProductOfArrayExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        val answer = IntArray(nums.size)
        var product = 1
        for (i in answer.indices) {
            answer[i] = product
            product *= nums[i]
        }
        product = 1
        for (i in answer.indices.reversed()) {
            answer[i] *= product
            product *= nums[i]
        }
        return answer
    }
}