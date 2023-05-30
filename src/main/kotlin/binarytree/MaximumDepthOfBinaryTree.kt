package binarytree

import kotlin.math.max

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

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}