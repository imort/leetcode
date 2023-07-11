package dynamic

/**
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 *
 * An interleaving of two strings s and t is a configuration where s and t are divided into n and m
 * substrings respectively, such that:
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * Note: a + b is the concatenation of strings a and b.
 */
class InterleavingString {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        if (s1.length + s2.length != s3.length) return false
        //if (s2.length > s1.length) return isInterleave(s2, s1, s3)
        val valid = Array(s1.length + 1) { BooleanArray(s2.length + 1) }

        for (i in 0..s1.length) {
            for (j in 0..s2.length) {
                valid[i][j] = when {
                    i == 0 && j == 0 -> true
                    else -> {
                        val char = s3[i + j - 1]
                        when {
                            i == 0 -> valid[i][j - 1] && char == s2[j - 1]
                            j == 0 -> valid[i - 1][j] && char == s1[i - 1]
                            else -> (valid[i][j - 1] && char == s2[j - 1]) || (valid[i - 1][j] && char == s1[i - 1])
                        }
                    }
                }
            }
        }

        return valid[s1.length][s2.length]
    }
}