package matrix

import matrix.SpiralMatrix.Direction.*

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 */
class SpiralMatrix {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        if (matrix.isEmpty()) return emptyList()
        val result = mutableListOf<Int>()
        var direction = R
        var iStart = 0
        var iEnd = matrix.lastIndex
        var jStart = 0
        var jEnd = matrix[0].lastIndex
        var i = 0
        var j = 0
        while (true) {
            result += matrix[i][j]
            if (!direction.canGo(i, j, iStart, iEnd, jStart, jEnd)) {
                direction = direction.next
                if (!direction.canGo(i, j, iStart, iEnd, jStart, jEnd)) break
                when (direction) {
                    R -> jStart++
                    B -> iStart++
                    L -> jEnd--
                    U -> iEnd--
                }
            }
            when (direction) {
                R -> j++
                B -> i++
                L -> j--
                U -> i--
            }
        }
        return result
    }

    private fun Direction.canGo(i: Int, j: Int, iStart: Int, iEnd: Int, jStart: Int, jEnd: Int): Boolean {
        return when (this) {
            R -> j < jEnd
            B -> i < iEnd
            L -> j > jStart
            U -> i > iStart
        }
    }

    private enum class Direction {
        R, B, L, U;

        val next: Direction
            get() = when (this) {
                R -> B
                B -> L
                L -> U
                U -> R
            }
    }
}