package hashmap

class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        return strs
            .groupBy(::characterOccurrences)
            .values
            .toList()
    }

    private fun characterOccurrences(string: String): Map<Char, Int> {
        return string.toCharArray().groupBy { it }.mapValues { it.value.size }
    }
}