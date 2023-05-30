package dynamic

import org.junit.jupiter.api.Test

class TriangleTest {

    @Test
    fun minimumTotal() {
        val test = Triangle()
        val case = listOf(
            listOf(2),
            listOf(3, 4),
            listOf(6, 5, 7),
            listOf(4, 1, 8, 3),
        )
        val result = test.minimumTotal(case)
        assert(result == 11) { "Got $result" }
    }
}