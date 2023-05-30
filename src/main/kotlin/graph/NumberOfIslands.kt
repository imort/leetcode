package graph

class NumberOfIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        var count = 0
        for (i in grid.indices) {
            inner@ for (j in grid[i].indices) {
                if (grid[i][j] == '1') {
                    traverse(i, j, grid)
                    count++
                }
            }
        }
        return count
    }

    private fun traverse(i: Int, j: Int, grid: Array<CharArray>) {
        if (i >= 0 && i < grid.size && j >=0 && j < grid[i].size && grid[i][j] == '1') {
            grid[i][j] = '0'
            traverse(i-1, j, grid)
            traverse(i, j-1, grid)
            traverse(i, j+1, grid)
            traverse(i+1, j, grid)
        }
    }
}