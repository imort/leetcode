package binarytree

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

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}