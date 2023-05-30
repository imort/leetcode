package math

class PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        val s = x.toString()
        return s == s.reversed()
    }
}