package slidingwindow

import org.junit.jupiter.api.Test

class SubstringWithConcatenationOfAllWordsTest {
    @Test
    fun findSubstring() {
        with(SubstringWithConcatenationOfAllWords()) {
            test("barfoothefoobarman", arrayOf("foo", "bar"), listOf(0, 9))
            test("wordgoodgoodgoodbestword", arrayOf("word", "good", "best", "word"), emptyList())
            test("wordgoodgoodgoodbestword", arrayOf("word", "good", "best", "good"), listOf(8))
            test("barfoofoobarthefoobarman", arrayOf("bar", "foo", "the"), listOf(6, 9, 12))
            test("zbarfoofoobarthefoobarman", arrayOf("bar", "foo", "the"), listOf(7, 10, 13))
        }
    }

    private fun SubstringWithConcatenationOfAllWords.test(s: String, words: Array<String>, result: List<Int>) {
        val returned = findSubstring(s, words)
        assert(returned == result) { "Got [${returned.joinToString()}]" }
    }
}