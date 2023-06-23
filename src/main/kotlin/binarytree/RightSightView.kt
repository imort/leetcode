package binarytree

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 */
class RightSightView {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        val result = mutableListOf<Int>()

        val marker = TreeNode(0)
        val queue = ArrayDeque<TreeNode>()
        queue.addLast(marker)
        queue.addLast(root)
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            if (node === marker) {
                if (queue.isNotEmpty()) {
                    result += queue.first().`val`
                    queue.addLast(marker)
                }
            } else {
                node.right?.let { queue.addLast(it) }
                node.left?.let { queue.addLast(it) }
            }
        }
        return result
    }
}