package matrix

/**
 * According to Wikipedia's article: "The Game of Life, also known simply as Life,
 * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 *
 * The board is made up of an m x n grid of cells, where each cell has an initial state:
 * live (represented by a 1) or dead (represented by a 0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
 * using the following four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 *
 * The next state is created by applying the above rules simultaneously to every cell in the current state,
 * where births and deaths occur simultaneously.
 * Given the current state of the m x n grid board, return the next state.
 */
class GameOfLife {
    fun gameOfLife(board: Array<IntArray>): Unit {
        val n = board.size
        val m = board[0].size
        // calculate state
        for (i in 0 until n) {
            for (j in 0 until m) {
                val curr = board[i][j].currentState()
                val neighbors = neighbors(board, n, m, i, j)
                val next = when (curr) {
                    0 -> if (neighbors == 3) 1 else 0
                    1 -> when (neighbors) {
                        2, 3 -> 1
                        else -> 0
                    }
                    else -> error("Unexpected current value $curr at $i $j")
                }
                board[i][j] = curr.addNextState(next)
            }
        }
        // apply next state
        for (i in 0 until n) {
            for (j in 0 until m) {
                board[i][j] = board[i][j].nextState()
            }
        }
    }

    private fun neighbors(board: Array<IntArray>, n: Int, m: Int, i: Int, j: Int): Int {
        var count = 0
        for (ii in (i - 1).coerceAtLeast(0)..(i + 1).coerceAtMost(n - 1)) {
            for (jj in (j - 1).coerceAtLeast(0)..(j + 1).coerceAtMost(m - 1)) {
                if (ii == i && jj == j) continue
                count += board[ii][jj].currentState()
            }
        }
        return count
    }

    private fun Int.currentState() = this and 1
    private fun Int.nextState() = this shr 1
    private fun Int.addNextState(next: Int) = this or (next shl 1)
}