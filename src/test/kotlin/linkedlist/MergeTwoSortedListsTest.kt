package linkedlist

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MergeTwoSortedListsTest {
    @Test
    fun mergeTwoLists() {
        with(MergeTwoSortedLists()) {
            test(emptyList(), emptyList(), emptyList())
            test(listOf(0), emptyList(), listOf(0))
            test(listOf(1, 1, 2, 3, 4, 4), listOf(1, 2, 4), listOf(1, 3, 4))
        }
    }

    private fun MergeTwoSortedLists.test(expected: List<Int>, list1: List<Int>, list2: List<Int>) {
        assertEquals(expected, mergeTwoLists(list1.asNode(), list2.asNode()).asList())
    }
}