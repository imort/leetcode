package linkedlist

/**
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 */
class ReverseLinkedList2 {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        var counter = 0
        var iterator = head
        var tailBase: ListNode? = null
        var headReversed: ListNode? = null
        var tailReversed: ListNode? = null
        while (iterator != null) {
            val next = iterator.next
            when (++counter) {
                left - 1 -> {
                    tailBase = iterator
                }
                left -> {
                    headReversed = iterator
                    tailReversed = iterator
                }
                in (left + 1)..right -> {
                    iterator.next = headReversed
                    headReversed = iterator
                }
            }
            if (counter == right) {
                tailBase?.next = iterator
                tailReversed?.next = next
                break
            }
            iterator = next
        }
        return if (left > 1) head else headReversed
    }
}