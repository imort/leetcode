package backtracking

/**
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 */
class Permutations {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        permute(nums.toSet(), emptyList(), result)
        return result
    }

    private fun permute(currentSet: Set<Int>, currentResult: List<Int>, result: MutableList<List<Int>>) {
        if (currentSet.isEmpty()) {
            result.add(currentResult)
            return
        }
        for (num in currentSet) {
            permute(currentSet - num, currentResult + num, result)
        }
    }
}