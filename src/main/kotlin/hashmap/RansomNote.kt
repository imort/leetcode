package hashmap

object RansomNote {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val map = magazine.asIterable().groupingBy { it }.eachCount().toMutableMap()
        for (char in ransomNote) {
            val count = map[char] ?: return false
            if (count == 0) return false
            map[char] = count - 1
        }
        return true
    }
}