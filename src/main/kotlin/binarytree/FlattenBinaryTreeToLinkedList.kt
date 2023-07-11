package binarytree

/**
 * Given the root of a binary tree, flatten the tree into a "linked list":
 *
 * The "linked list" should use the same TreeNode class where the right child pointer
 * points to the next node in the list and the left child pointer is always null.
 *
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 */
class FlattenBinaryTreeToLinkedList {
    fun flatten(root: TreeNode?) {
        root?.flattenRight()
    }

    private fun TreeNode?.flattenRight(): TreeNode? {
        var node = this ?: return null
        val fl = left.flattenRight()
        val fr = right.flattenRight()
        left = null
        right = fl

        while (true) node = node.right ?: break
        node.right = fr

        return this
    }
}