package binarysearchtree

import binarytree.TreeNode

/**
 * Given the root of a binary search tree, and an integer k,
 * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */
class KthSmallestElement {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        if (root == null) return -1
        val stack = ArrayDeque<TreeNode>()
        var node = root
        var counter = k
        while (node != null || stack.isNotEmpty()) {
            while (node != null) {
                stack.addFirst(node)
                node = node.left
            }
            node = stack.removeFirst()
            if (--counter == 0) return node.`val`
            node = node.right
        }
        return -1
    }
}