package dynamic

class WordBreak {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        if (s.isEmpty()) return false
        val dic = wordDict.sortedBy { it.length }
        val length = s.length
        val valid = BooleanArray(length + 1) { false }
        valid[0] = true
        for (index in 0..s.lastIndex) {
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