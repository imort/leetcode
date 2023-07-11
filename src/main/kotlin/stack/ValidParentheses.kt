package stack

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
class ValidParentheses {
    fun isValid(s: String): Boolean {
        val open = setOf('{', '[', '(')
        val close = setOf('}', ']', ')')
        val map = mapOf(
            '}' to '{',
            ']' to '[',
            ')' to '('
        )
        val stack = ArrayDeque<Char>()
        for (char in s) {
            when (char) {
                in open -> stack.addFirst(char)
                in close -> {
                    if (stack.isEmpty()) return false
                    val stacked = stack.removeFirst()
                    if (map[char] != stacked) return false
                }
                else -> return false
            }
        }
        return stack.isEmpty()
    }
}