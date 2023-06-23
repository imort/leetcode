package hashmap

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ValidAnagramTest {
    @Test
    fun isAnagram() {
        with(ValidAnagram()) {
            test(true, "anagram", "nagaram")
            test(false, "rat", "car")
        }
    }

    private fun ValidAnagram.test(expected: Boolean, s: String, t: String) {
        assertEquals(expected, isAnagram(s, t))
    }
}