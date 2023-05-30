package matrix

class RotateImage {
    fun rotate(matrix: Array<IntArray>): Unit {
        matrix.reverse()
        val n = matrix.size
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                matrix[i][j] = matrix[j][i].also { matrix[j][i] = matrix[i][j] }
            }
        }
    }
}