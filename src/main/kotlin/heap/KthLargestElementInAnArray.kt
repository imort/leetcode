package heap

import java.util.*

class KthLargestElementInAnArray {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val queue = PriorityQueue<Int>(Collections.reverseOrder())
        for (num in nums) queue.offer(num)
        var result = 0
        repeat(k) {
            result = queue.poll()
        }
        return result
    }
}