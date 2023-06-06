package slidingwindow

import kotlin.math.max

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */
class LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(s: String): Int {
        val length = s.length
        if (length <= 1) return length

        var result = 1
        var start = 0
        var end = 1
        val met = mutableSetOf(s[start])
        do {
            val char = s[end]
            if (char in met) {
                while (s[start] != char) {
                    met -= s[start]
                    start++
                }
                start++
            } else {
                met += char
            }
            result = max(result, end - start + 1)
        } while (++end < length)
        return result
    }
}