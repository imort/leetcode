package backtracking

import org.junit.jupiter.api.Test

class PermutationsTest {

    @Test
    fun permute() {
        with(Permutations()) {
            test(intArrayOf(1), listOf(listOf(1)))
            test(intArrayOf(1, 2), listOf(listOf(1, 2), listOf(2, 1)))
            test(
                intArrayOf(1, 2, 3), listOf(
                    listOf(1, 2, 3),
                    listOf(1, 3, 2),
                    listOf(2, 1, 3),
                    listOf(2, 3, 1),
                    listOf(3, 1, 2),
                    listOf(3, 2, 1),
                )
            )
        }
    }

    private fun Permutations.test(nums: IntArray, result: List<List<Int>>) {
        val r = permute(nums)
        assert(r == result) {
            "Got ${r.joinToString { it.joinToString(prefix = "[", postfix = "]") }}"
        }
    }
}