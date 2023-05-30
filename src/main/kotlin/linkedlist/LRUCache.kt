package linkedlist

class LRUCache(private val capacity: Int) {
    private val head = Node(-1, -1)
    private val tail = Node(-1, -1)
    private val map = mutableMapOf<Int, Node>()

    private var size = 0

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        return map[key]?.also(::moveFirst)?.value ?: -1
    }

    fun put(key: Int, value: Int) {
        val node = map[key]
        if (node == null) {
            val newNode = Node(key, value)
            map[key] = newNode
            addFirst(newNode)
        } else {
            node.value = value
            moveFirst(node)
        }
    }

    private fun increaseSize() {
        size++
        if (size > capacity) removeLast()
    }

    private fun addFirst(node: Node) {
        val second = head.next
        node.prev = head
        node.next = second
        head.next = node
        second?.prev = node
        increaseSize()
    }

    private fun moveFirst(node: Node) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
        val second = head.next
        head.next = node
        node.prev = head
        second?.prev = node
        node.next = second
    }

    private fun removeLast() {
        val node = tail.prev
        if (node == head || node == null) return

        map.remove(node.key)

        val second = node.prev
        second?.next = tail
        tail.prev = second
        node.prev = null
        node.next = null

        size--
    }

    private class Node(
        val key: Int,
        var value: Int,
        var prev: Node? = null,
        var next: Node? = null,
    )
}