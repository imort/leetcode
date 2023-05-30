package array

import kotlin.math.max

class Candy {
    // there is much better solution
    fun candy(ratings: IntArray): Int {
        if (ratings.isEmpty()) return 0
        val candies = IntArray(ratings.size) { 1 }
        val indexes = ratings.indices.sortedBy { ratings[it] }
        for (i in 1..indexes.lastIndex) {
            val index = indexes[i]
            val rating = ratings[index]
            val left = if (index > 0 && rating > ratings[index - 1])
                candies[index - 1] else Integer.MIN_VALUE
            val right = if (index < ratings.lastIndex && rating > ratings[index + 1])
                candies[index + 1] else Integer.MIN_VALUE
            candies[index] = max(1, max(left, right) + 1)
        }
        return candies.sum()
    }
}