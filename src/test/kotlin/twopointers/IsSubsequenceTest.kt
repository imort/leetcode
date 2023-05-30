package twopointers

import org.junit.jupiter.api.Test

class IsSubsequenceTest {
    @Test
    fun test() {
        val test = IsSubsequence()
        assert(test.isSubsequence("abc", "aabbcc"))
    }
}