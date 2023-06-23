package binarytree

/**
 * Given two integer arrays preorder and inorder
 * where preorder is the preorder traversal of a binary tree
 * and inorder is the inorder traversal of the same tree,
 * construct and return the binary tree.
 *
 * Constraints:
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 */
class BinaryTreeFromPreorderInorder {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        return find(preorder, 0, inorder, 0, inorder.lastIndex)
    }

    private fun find(preorder: IntArray, preIndex: Int, inorder: IntArray, inStart: Int, inEnd: Int): TreeNode? {
        if (preIndex !in preorder.indices || inStart > inEnd) return null
        val value = preorder[preIndex]
        val node = TreeNode(value)
        var inIndex = -1
        for (i in inStart..inEnd) {
            if (inorder[i] == value) {
                inIndex = i
                break
            }
        }
        node.left = find(preorder, preIndex + 1, inorder, inStart, inIndex - 1)
        node.right = find(preorder, preIndex + 1 + (inIndex - inStart), inorder, inIndex + 1, inEnd)
        return node
    }
}