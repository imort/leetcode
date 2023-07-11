package math

/**
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 */
class PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        val s = x.toString()
        return s == s.reversed()
    }
}