package array

/**
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 *
 * A word is a maximal substring consisting of non-space characters only.
 */
class LengthOfLastWord {
    fun lengthOfLastWord(s: String): Int {
        return s.split(' ').lastOrNull { it.isNotEmpty() }?.length ?: 0
    }
}