package divideconquer

import binarytree.TreeNode

/**
 * Given an integer array nums where the elements are sorted in ascending order,
 * convert it to a height-balanced binary search tree
 *
 * A height-balanced binary tree is a binary tree in which
 * the depth of the two subtrees of every node never differs by more than one.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in a strictly increasing order.
 */
class SortedArrayToBST {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return fill(nums, 0, nums.lastIndex)
    }

    private fun fill(nums: IntArray, start: Int, end: Int): TreeNode? = when {
        start > end -> null
        start == end -> TreeNode(nums[start])
        else -> {
            val mid = start + (end - start) / 2
            TreeNode(nums[mid]).apply {
                left = fill(nums, start, mid - 1)
                right = fill(nums, mid + 1, end)
            }
        }
    }
}