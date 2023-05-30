package stack

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