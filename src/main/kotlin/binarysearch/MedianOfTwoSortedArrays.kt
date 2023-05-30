package binarysearch

import java.util.*

class MedianOfTwoSortedArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        if (nums1.size < nums2.size) return findMedianSortedArrays(nums2, nums1)
        val merged = nums1.toCollection(LinkedList())
        for (num in nums2) {
            merged.sortedInsert(num)
        }
        val size = merged.size
        val mid = size / 2
        return if (size % 2 == 1) merged[mid].toDouble() else (merged[mid - 1] + merged[mid]) / 2.0
    }

    private tailrec fun LinkedList<Int>.sortedInsert(num: Int, start: Int = 0, end: Int = lastIndex) {
        if (start > end) return add(start, num)
        val mid = start + (end - start) / 2
        if (num > get(mid)) {
            sortedInsert(num, mid + 1, end)
        } else {
            sortedInsert(num, start, mid - 1)
        }
    }
}