package slidingwindow

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring
 * of s such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 */
class MinimumWindowSubstring {
    fun minWindow(s: String, t: String): String {
        if (t.isEmpty()) return ""
        val frequencies = IntArray(128)
        t.chars().forEach { frequencies[it]++ }

        var result = ""
        var count = t.length
        var start = 0
        var end = 0
        while (end < s.length) {
            val charEnd = s[end].code
            if (frequencies[charEnd]-- > 0) count--
            if (count == 0) {
                while (count == 0) {
                    val charStart = s[start].code
                    if (++frequencies[charStart] > 0) count++
                    start++
                }
                if (result.isEmpty() || result.length > end - start + 2) {
                    result = s.substring(start - 1, end + 1)
                }
            }
            end++
        }
        return result
    }
}