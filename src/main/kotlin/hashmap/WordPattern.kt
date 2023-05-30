package hashmap

class WordPattern {
    fun wordPattern(pattern: String, s: String): Boolean {
        val words = s.split(' ')
        if (pattern.length != words.size) return false
        val map = mutableMapOf<Char, String>()
        val wordSet = mutableSetOf<String>()
        for (i in pattern.indices) {
            val value = map[pattern[i]]
            val word = words[i]
            if (value == null) {
                if (!wordSet.add(word)) return false
                map[pattern[i]] = word
            } else {
                if (value != word) return false
            }
        }
        return true
    }
}