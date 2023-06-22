package linkedlist

/**
 * Given the head of a linked list, rotate the list to the right by k places.
 */
class RotateList {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        var iterator = head ?: return null
        var size = 1
        while (iterator.next != null) {
            size++
            iterator = iterator.next!!
        }
        val kk = k % size
        if (kk == 0) return head
        val shift = size - kk
        iterator.next = head // cycle
        iterator = head
        repeat(shift - 1) {
            iterator = iterator.next!!
        }
        val newHead = iterator.next
        iterator.next = null
        return newHead
    }
}