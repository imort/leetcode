package binarytree

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
class SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        return mirror(root?.left, root?.right)
    }

    private fun mirror(first: TreeNode?, second: TreeNode?): Boolean {
        if (first == null) return second === null
        if (first.`val` != second?.`val`) return false
        return mirror(first.left, second.right) && mirror(first.right, second.left)
    }
}