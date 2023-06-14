package stack

import java.util.*

/**
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it,
 * and return the result of the evaluation.
 *
 * Note: You are not allowed to use any built-in function
 * which evaluates strings as mathematical expressions, such as eval().
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 105
 * s consists of digits, '+', '-', '(', ')', and ' '.
 * s represents a valid expression.
 * '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
 * '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
 * There will be no two consecutive operators in the input.
 * Every number and running calculation will fit in a signed 32-bit integer.
 */
class BasicCalculator {
    fun calculate(s: String): Int {
        val input = s.filterNot(Char::isWhitespace)
        var result = 0
        var i = 0
        val stack = LinkedList<Int>()
        var parenSigns = 1
        var prevSign = 1
        while (i < input.length) {
            when (input[i]) {
                '(' -> {
                    stack.push(prevSign)
                    if (prevSign < 0) parenSigns *= -1
                    prevSign = 1
                }

                ')' -> {
                    if (stack.pop() < 0) parenSigns *= -1
                }

                '+' -> {
                    prevSign = 1
                }

                '-' -> {
                    prevSign = -1
                }

                else -> {
                    var n = 0
                    while (i < input.length) {
                        val c = input[i]
                        if (!c.isDigit()) break
                        val digit = c - '0'
                        n = n * 10 + digit
                        i++
                    }
                    i--
                    result += n * parenSigns * prevSign
                }
            }
            i++
        }
        return result
    }
}