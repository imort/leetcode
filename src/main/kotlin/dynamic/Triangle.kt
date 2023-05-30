package dynamic

import kotlin.math.min

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