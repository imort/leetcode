package dynamic

import org.junit.jupiter.api.Test

class WordBreakTest {

    @Test
    fun wordBreak() {
        val test = WordBreak()

        assert(test.wordBreak("leetcode", listOf("leet", "code")))
        assert(test.wordBreak("applepenapple", listOf("apple", "pen")))

        val s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        val dict =
            listOf("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")
        assert(!test.wordBreak("b${s}", dict))
        assert(!test.wordBreak("${s}b", dict))
    }
}