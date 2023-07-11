package binarysearch

/**
 * You are given an m x n integer matrix with the following two properties:
 *
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 *
 * You must write a solution in O(log(m * n)) time complexity.
 */
class SearchMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val n = matrix.size
        if (n == 0) return false
        val m = matrix[0].size
        if (m == 0) return false
        var left = 0
        var right = n * m - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            val i = mid / m
            val j = mid % m
            val pick = matrix[i][j]
            when {
                pick == target -> return true
                pick < target -> left = mid + 1
                else -> right = mid - 1
            }
        }
        return false
    }
}