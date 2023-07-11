package binarytree

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 * Example:
 *
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 */
class InvertBinaryTree {
    fun invertTree(root: TreeNode?): TreeNode? {
        return root.invert()
    }

    private fun TreeNode?.invert(): TreeNode? {
        return this?.apply {
            left = right.invert().also { right = left.invert() }
        }
    }
}