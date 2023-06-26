package hashmap

/**
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 */
class HappyNumber {
    fun isHappy(n: Int): Boolean {
        var slow = n
        var fast = n
        do {
            slow = slow.happyNext()
            if (slow == 1) break
            fast = fast.happyNext().happyNext()
        } while (fast != slow)
        return slow == 1
    }

    private fun Int.happyNext(): Int {
        var temp = this
        var result = 0
        while (temp > 0) {
            val digit = temp % 10
            result += digit * digit
            temp /= 10
        }
        return result
    }
}