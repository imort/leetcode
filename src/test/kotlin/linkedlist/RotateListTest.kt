package linkedlist

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RotateListTest {
    @Test
    fun rotateRight() {
        with(RotateList()) {
            test(listOf(2, 1), listOf(1, 2), 1)
            test(listOf(4, 5, 1, 2, 3), listOf(1, 2, 3, 4, 5), 2)
            test(listOf(2, 0, 1), listOf(0, 1, 2), 4)
            test(listOf(1, 2), listOf(1, 2), 2)
        }
    }

    private fun RotateList.test(expected: List<Int>, list: List<Int>, k: Int) {
        assertEquals(expected, rotateRight(list.asNode(), k).asList())
    }
}