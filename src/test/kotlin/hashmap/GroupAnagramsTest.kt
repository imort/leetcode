package hashmap

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GroupAnagramsTest {
    @Test
    fun groupAnagrams() {
        with(GroupAnagrams()) {
            test(
                listOf(listOf("eat", "tea", "ate"), listOf("tan", "nat"), listOf("bat")),
                arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
            )
        }
    }

    private fun GroupAnagrams.test(expected: List<List<String>>, input: Array<String>) {
        assertEquals(expected, groupAnagrams(input))
    }
}