package dynamic

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class InterleavingStringTest {

    @Test
    fun isInterleave() {
        val test = InterleavingString()
        assert(test.isInterleave("", "", ""))
        assert(test.isInterleave("aabcc", "dbbca", "aadbbcbcac"))
    }
}