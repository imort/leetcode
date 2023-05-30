package twopointers

class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        val chars = s.lowercase().toCharArray()
        var start = 0
        var end = chars.lastIndex
        while (true) {
            while (start < chars.size && !chars[start].isLetterOrDigit()) start++
            while (end >= 0 && !chars[end].isLetterOrDigit()) end--
            if (start >= end) break
            if (chars[start] != chars[end]) return false
            start++
            end--
        }
        return true
    }
}