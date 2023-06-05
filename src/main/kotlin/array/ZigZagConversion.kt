package array

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 */
class ZigZagConversion {
    fun convert(s: String, numRows: Int): String {
        if (numRows <= 1) return s
        val sb = StringBuilder()
        for (rowIndex in 0 until numRows) {
            val primaryShift = (numRows - 1 - rowIndex) * 2
            val secondaryShift = rowIndex * 2

            var primary = true
            var current = rowIndex
            while (current < s.length) {
                sb.append(s[current])
                current += when {
                    primaryShift <= 0 -> secondaryShift
                    secondaryShift <= 0 -> primaryShift
                    else -> (if (primary) primaryShift else secondaryShift).also { primary = !primary }
                }
            }
        }
        return sb.toString()
    }
}