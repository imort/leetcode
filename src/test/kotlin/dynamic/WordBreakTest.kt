package dynamic

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class WordBreakTest {
    @Test
    fun wordBreak() {
        with(WordBreak()) {
            test(true, "leetcode", listOf("leet", "code"))
            test(true, "applepenapple", listOf("apple", "pen"))
            val s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
            val dict =
                listOf("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")
            test(true, s, dict)
            test(false, "b${s}", dict)
            test(false, "${s}b", dict)
        }
    }

    private fun WordBreak.test(expected: Boolean, s: String, wordDict: List<String>) {
        assertEquals(expected, wordBreak(s, wordDict))
    }
}