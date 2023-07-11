package linkedlist

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
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
}