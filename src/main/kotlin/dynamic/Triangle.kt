package dynamic

import kotlin.math.min

/**
 * Given a triangle array, return the minimum path sum from top to bottom.
 * For each step, you may move to an adjacent number of the row below.
 * More formally, if you are on index i on the current row,
 * you may move to either index i or index i + 1 on the next row.
 *
 * Example:
 *
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11.
 */
class Triangle {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val rowLastIndex = triangle.lastIndex
        val sums = IntArray(triangle.size) { triangle[rowLastIndex][it] }
        for (rowIndex in rowLastIndex - 1 downTo 0) {
            val row = triangle[rowIndex]
            for (colIndex in row.indices) {
                sums[colIndex] = min(sums[colIndex], sums[colIndex + 1]) + row[colIndex]
            }
        }
        return sums[0]
    }
}