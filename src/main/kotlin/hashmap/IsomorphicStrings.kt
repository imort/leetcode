package hashmap

class IsomorphicStrings {
    fun isIsomorphic(s: String, t: String): Boolean {
        val swaps = s.zip(t).toSet().size
        return swaps == s.toSet().size && swaps == t.toSet().size
    }
}