package stack

/**
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 *
 * Evaluate the expression. Return an integer that represents the value of the expression.
 *
 * Note that:
 *
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 */
class EvaluateReversePolishNotation {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()
        for (token in tokens) {
            when (val t = Token.parse(token)) {
                is Token.Num -> stack.addFirst(t.value)
                is Token.Operation -> {
                    val second = stack.removeFirst()
                    val first = stack.removeFirst()
                    stack.addFirst(t.perform(first, second))
                }
            }
        }
        return stack.first()
    }

    private sealed class Token {
        data class Num(val value: Int) : Token()
        sealed class Operation : Token() {
            abstract fun perform(first: Int, second: Int): Int

            object Plus : Operation() {
                override fun perform(first: Int, second: Int): Int = first + second
            }

            object Minus : Operation() {
                override fun perform(first: Int, second: Int): Int = first - second
            }

            object Mult : Operation() {
                override fun perform(first: Int, second: Int): Int = first * second
            }

            object Div : Operation() {
                override fun perform(first: Int, second: Int): Int = first / second
            }
        }

        companion object {
            val operationMap = mapOf(
                "+" to Operation.Plus,
                "-" to Operation.Minus,
                "*" to Operation.Mult,
                "/" to Operation.Div,
            )

            fun parse(token: String): Token = when (val operation = operationMap[token]) {
                null -> Num(token.toInt())
                else -> operation
            }
        }
    }
}