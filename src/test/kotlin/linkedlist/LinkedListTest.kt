package linkedlist

fun List<Int>.asNode(): ListNode? {
    if (isEmpty()) return null
    val head = ListNode(this[0])
    var iterator = head
    for (i in 1 until size) {
        val node = ListNode(this[i])
        iterator.next = node
        iterator = node
    }
    return head
}

fun ListNode?.asList(): List<Int> {
    val result = mutableListOf<Int>()
    var iterator: ListNode? = this
    while (iterator != null) {
        result += iterator.`val`
        iterator = iterator.next
    }
    return result
}
