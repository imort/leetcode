package binarytree

import kotlin.math.max

/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 10^4].
 * -100 <= Node.val <= 100
 */
class MaximumDepthOfBinaryTree {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        root.`val` = 1

        val stack = ArrayDeque<TreeNode>()
        stack.addFirst(root)
        var depth = 0
        while (stack.isNotEmpty()) {
            val node = stack.removeFirst()
            val currentDepth = node.`val`
            depth = max(currentDepth, depth)
            node.right?.let {
                it.`val` = currentDepth + 1
                stack.addFirst(it)
            }
            node.left?.let {
                it.`val` = currentDepth + 1
                stack.addFirst(it)
            }
        }
        return depth
    }
}