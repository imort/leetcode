package linkedlist

class RemoveNthNodeFromTheEnd {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) return null
        var remove = head
        var prev: ListNode? = null
        var node = head
        var i = 0
        while (node != null) {
            node = node.next
            if (++i > n) {
                prev = remove
                remove = remove?.next
            }
        }
        if (remove == head) {
            return head.next
        }
        prev?.next = remove?.next
        remove?.next = null
        return head
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}