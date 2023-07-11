package dynamic

/**
 * Given a string s and a dictionary of strings wordDict,
 * return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * Constraints:
 *
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 */
class WordBreak {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        if (s.isEmpty()) return false
        val dic = wordDict.sortedBy { it.length }
        val length = s.length
        val valid = BooleanArray(length + 1)
        valid[0] = true
        for (index in s.indices) {
            if (!valid[index]) continue
            for (word in dic) {
                val wordLength = word.length
                if (index + wordLength > length) break
                if (s.substring(index, index + wordLength) == word) {
                    if (index + wordLength == length) return true
                    valid[index + wordLength] = true
                }
            }
        }
        return false
    }
}