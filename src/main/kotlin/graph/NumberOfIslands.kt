package graph

/**
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water),
 * return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'
 */
class NumberOfIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        var count = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == '1') {
                    traverse(i, j, grid)
                    count++
                }
            }
        }
        return count
    }

    private fun traverse(i: Int, j: Int, grid: Array<CharArray>) {
        if (i >= 0 && i < grid.size && j >= 0 && j < grid[i].size && grid[i][j] == '1') {
            grid[i][j] = '0'
            traverse(i - 1, j, grid)
            traverse(i, j - 1, grid)
            traverse(i, j + 1, grid)
            traverse(i + 1, j, grid)
        }
    }
}