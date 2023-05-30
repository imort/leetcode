package binarysearchtree

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

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}