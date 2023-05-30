package array

class MergeSortedArray {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        System.arraycopy(nums2, 0, nums1, m, n)
        nums1.sort()
    }
}