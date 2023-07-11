package backtracking

/**
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 *
 * You may return the answer in any order.
 */
class Combinations {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        for (i in 1..n) {
            update(result, i, n, k)
        }
        return result
    }

    private fun update(
        result: MutableList<List<Int>>,
        start: Int,
        end: Int,
        length: Int,
        combination: MutableList<Int> = mutableListOf()
    ) {
        combination.add(start)
        val lengthLeft = length - 1
        if (lengthLeft == 0) {
            result.add(combination)
            return
        }
        for (i in start + 1..end - lengthLeft + 1) {
            update(result, i, end, lengthLeft, combination.toMutableList())
        }
    }
}