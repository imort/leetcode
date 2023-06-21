package linkedlist

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseLinkedList2Test {
    @Test
    fun reverseBetween() {
        with(ReverseLinkedList2()) {
            test(listOf(1, 4, 3, 2, 5), listOf(1, 2, 3, 4, 5), 2, 4)
            test(listOf(5, 4, 3, 2, 1), listOf(1, 2, 3, 4, 5), 1, 5)
        }
    }

    private fun ReverseLinkedList2.test(expected: List<Int>, input: List<Int>, left: Int, right: Int) {
        assertEquals(expected, reverseBetween(input.asNode(), left, right).asList())
    }
}