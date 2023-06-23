package hashmap

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        return s.frequencyMap() == t.frequencyMap()
    }

    private fun String.frequencyMap(): Map<Char, Int> {
        val map = mutableMapOf<Char, Int>()
        for (c in this) {
            val count = map.putIfAbsent(c, 0) ?: 0
            map[c] = count + 1
        }
        return map
    }
}