package binarytree

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

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}