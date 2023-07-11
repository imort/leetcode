package bit

/**
 * Given two integers left and right that represent the range [left, right],
 * return the bitwise AND of all numbers in this range, inclusive.
 */
class BitwiseAndOfNumbersRange {
    fun rangeBitwiseAnd(left: Int, right: Int): Int {
        if (left == 0) return 0
        var l = left
        var r = right
        var count = 0
        while (l != r) {
            l = l shr 1
            r = r shr 1
            count++
        }
        return l shl count
    }
}