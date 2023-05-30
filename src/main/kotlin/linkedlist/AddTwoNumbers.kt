package linkedlist

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var root: ListNode? = null
        var curr: ListNode? = null
        var remainder = 0
        var left = l1
        var right = l2
        while (left != null || right != null || remainder != 0) {
            val leftValue = left?.`val` ?: 0
            val rightValue = right?.`val` ?: 0
            val newValue = leftValue + rightValue + remainder
            val newValueDigit = newValue % 10
            remainder = newValue / 10
            val node = ListNode(newValueDigit)
            if (root == null) root = node
            if (curr != null) {
                curr.next = node
            }
            curr = node
            left = left?.next
            right = right?.next
        }
        return root
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}