package linkedlist

class CopyListWithRandomPointer {
    fun copyRandomList(node: Node?): Node? {
        val oldToNew = HashMap<Node, Node>()

        var copy: Node?
        var curr: Node? = node

        while (curr != null) {
            copy = Node(curr.`val`)
            oldToNew[curr] = copy
            curr = curr.next
        }

        curr = node
        while (curr != null) {
            copy = oldToNew[curr]!!
            copy.next = oldToNew[curr.next]
            copy.random = oldToNew[curr.random]
            curr = curr.next
        }

        return oldToNew[node]
    }

    class Node(var `val`: Int) {
        var next: Node? = null
        var random: Node? = null
    }
}