package array

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 */
class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        val sb = StringBuilder()
        val pattern = strs.minBy(String::length)
        for (i in pattern.indices) {
            val char = pattern[i]
            val matched = strs.all { it[i] == char }
            if (matched) sb.append(char) else break
        }
        return sb.toString()
    }
}