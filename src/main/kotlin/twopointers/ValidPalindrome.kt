package twopointers

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * Constraints:
 *
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters
 */
class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        val ss = s.filter(Char::isLetterOrDigit).lowercase()
        var start = 0
        var end = ss.lastIndex
        while (start < end) {
            if (ss[start] != ss[end]) return false
            start++
            end--
        }
        return true
    }
}