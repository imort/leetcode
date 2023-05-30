package backtracking

import org.junit.jupiter.api.Test

class CombinationsTest {

    @Test
    fun combine() {
        val test = Combinations()
        assert(test.combine(1, 1) == listOf(listOf(1)))
        assert(
            test.combine(4, 2) == listOf(
                listOf(1, 2),
                listOf(1, 3),
                listOf(1, 4),
                listOf(2, 3),
                listOf(2, 4),
                listOf(3, 4)
            )
        )
    }
}