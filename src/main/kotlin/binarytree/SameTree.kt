package binarytree

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical,
 * and the nodes have the same value.
 */
class SameTree {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        return equals(p, q)
    }

    private fun equals(first: TreeNode?, second: TreeNode?): Boolean {
        if (first == null) return second === null
        if (first.`val` != second?.`val`) return false
        return equals(first.left, second.left) && equals(first.right, second.right)
    }
}