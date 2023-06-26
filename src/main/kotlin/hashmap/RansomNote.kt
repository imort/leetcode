package hashmap

/**
 * Given two strings ransomNote and magazine,
 * return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 */
object RansomNote {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val map = magazine.frequencyMap()
        for (char in ransomNote) {
            val count = map[char] ?: return false
            if (count == 0) return false
            map[char] = count - 1
        }
        return true
    }

    private fun String.frequencyMap(): MutableMap<Char, Int> {
        val map = mutableMapOf<Char, Int>()
        for (c in this) {
            val count = map.putIfAbsent(c, 0) ?: 0
            map[c] = count + 1
        }
        return map
    }
}