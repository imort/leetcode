package slidingwindow

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MinimumWindowSubstringTest {
    @Test
    fun minWindow() {
        with(MinimumWindowSubstring()) {
            test("BANC", "ADOBECODEBANC", "ABC")
            test("a", "a", "a")
            test("", "a", "aa")
            test("cwae", "cabwefgewcwaefgcf", "cae")
        }
    }

    private fun MinimumWindowSubstring.test(expected: String, s: String, t: String) {
        assertEquals(expected, minWindow(s, t))
    }
}