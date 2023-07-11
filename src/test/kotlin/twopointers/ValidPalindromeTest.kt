package twopointers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ValidPalindromeTest {
    @Test
    fun isPalindrome() {
        with(ValidPalindrome()) {
            test(true, "A man, a plan, a canal: Panama")
            test(false, "race a car")
            test(true, "")
            test(true, " ")
        }
    }

    private fun ValidPalindrome.test(expected: Boolean, s: String) {
        assertEquals(expected, isPalindrome(s))
    }
}