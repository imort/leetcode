package matrix

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 */
class RotateImage {
    fun rotate(matrix: Array<IntArray>) {
        matrix.reverse()
        val n = matrix.size
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                matrix[i][j] = matrix[j][i].also { matrix[j][i] = matrix[i][j] }
            }
        }
    }
}