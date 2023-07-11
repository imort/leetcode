package heap

import java.util.*

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Can you solve it without sorting?
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 105
 * -10000 <= nums[i] <= 10000
 */
class KthLargestElementInAnArray {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val heap = PriorityQueue<Int>(k)
        for (num in nums) {
            if (heap.size < k || num > heap.peek()) {
                while (heap.size >= k) heap.poll()
                heap.offer(num)
            }
        }
        return heap.poll()
    }
}