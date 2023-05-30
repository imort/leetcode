package matrix

class GameOfLife {
    // update in place
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