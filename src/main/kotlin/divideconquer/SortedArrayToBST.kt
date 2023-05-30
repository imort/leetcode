package divideconquer

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

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}