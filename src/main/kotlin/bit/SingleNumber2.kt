package bit

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