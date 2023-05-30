package twopointers

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