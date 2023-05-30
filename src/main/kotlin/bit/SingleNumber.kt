package bit

class SingleNumber {
    fun singleNumber(nums: IntArray): Int {
        var result = 0
        nums.forEach { result = result.xor(it) }
        return result
    }
}