package twopointers

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string
 * by deleting some (can be none) of the characters
 * without disturbing the relative positions of the remaining characters.
 *
 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */
class IsSubsequence {
    fun isSubsequence(s: String, t: String): Boolean {
        if (t.length < s.length) return false
        var ti = 0
        for (char in s) {
            while (ti < t.length && t[ti] != char) {
                ti++
            }
            if (ti == t.length) return false
            ti++
        }
        return true
    }
}