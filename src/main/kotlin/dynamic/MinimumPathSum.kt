package dynamic

import kotlin.math.min

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
 * which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 */
class MinimumPathSum {
    fun minPathSum(grid: Array<IntArray>): Int {
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                grid[i][j] = when {
                    i == 0 && j == 0 -> grid[i][j]
                    i == 0 -> grid[i][j] + grid[i][j - 1]
                    j == 0 -> grid[i][j] + grid[i - 1][j]
                    else -> grid[i][j] + min(grid[i][j - 1], grid[i - 1][j])
                }
            }
        }
        return grid[grid.lastIndex][grid[grid.lastIndex].lastIndex]
    }
}