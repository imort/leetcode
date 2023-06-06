package slidingwindow

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestSubstringWithoutRepeatingCharactersTest {
    @Test
    fun lengthOfLongestSubstring() {
        with(LongestSubstringWithoutRepeatingCharacters()) {
            test(3, "abcabcbb")
            test(1, "bbbbb")
            test(3, "pwwkew")
        }
    }

    private fun LongestSubstringWithoutRepeatingCharacters.test(expected: Int, s: String) {
        assertEquals(expected, lengthOfLongestSubstring(s))
    }
}