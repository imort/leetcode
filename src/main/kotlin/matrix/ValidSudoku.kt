package matrix

/**
 * Determine if a 9 x 9 Sudoku board is valid.
 * Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * Note:
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */
class ValidSudoku {
    private val temp = mutableSetOf<Char>()

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        for (index in 0 until SIZE) {
            if (!isValidRow(board, index)) return false
            if (!isValidColumn(board, index)) return false
            if (!isValidBox(board, index)) return false
        }
        return true
    }

    private fun isValidRow(board: Array<CharArray>, i: Int): Boolean {
        temp.clear()
        for (j in 0 until SIZE) {
            if (!valid(board[i][j])) return false
        }
        return true
    }

    private fun isValidColumn(board: Array<CharArray>, j: Int): Boolean {
        temp.clear()
        for (i in 0 until SIZE) {
            if (!valid(board[i][j])) return false
        }
        return true
    }

    private fun isValidBox(board: Array<CharArray>, index: Int): Boolean {
        temp.clear()
        val iStart = SB_SIZE * (index / SB_SIZE)
        val jStart = SB_SIZE * (index % SB_SIZE)
        for (i in iStart until iStart + SB_SIZE) {
            for (j in jStart until jStart + SB_SIZE) {
                if (!valid(board[i][j])) return false
            }
        }
        return true
    }

    private fun valid(char: Char): Boolean {
        return if (char.isDigit()) temp.add(char) else true
    }

    companion object {
        private const val SIZE = 9
        private const val SB_SIZE = 3
    }
}