package matrix

/**
 * Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
 * You must do it in place.
 *
 * A straightforward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
class SetMatrixZeroes {
    fun setZeroes(matrix: Array<IntArray>) {
        if (matrix.isEmpty()) return

        val n = matrix.size
        val m = matrix[0].size

        var firstRow = false
        var firstCol = false

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (matrix[i][j] == 0) {
                    if (i == 0) firstRow = true
                    if (j == 0) firstCol = true
                    matrix[0][j] = 0
                    matrix[i][0] = 0
                }
            }
        }
        for (i in 1 until n) {
            for (j in 1 until m) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0
                }
            }
        }

        if (firstRow) {
            for (j in 0 until m) {
                matrix[0][j] = 0
            }
        }
        if (firstCol) {
            for (i in 0 until n) {
                matrix[i][0] = 0
            }
        }
    }
}