package intervals

class SummaryRanges {
    fun summaryRanges(nums: IntArray): List<String> {
        if (nums.isEmpty()) return emptyList()
        val result = mutableListOf<String>()
        var start = 0
        for (i in 1..nums.lastIndex) {
            val curr = nums[i]
            val prev = nums[i-1]
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