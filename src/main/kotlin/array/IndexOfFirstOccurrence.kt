package array

/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 */
class IndexOfFirstOccurrence {
    fun strStr(haystack: String, needle: String): Int {
        return haystack.indexOf(needle)
    }
}