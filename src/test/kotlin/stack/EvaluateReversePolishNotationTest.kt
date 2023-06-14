package stack

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EvaluateReversePolishNotationTest {
    @Test
    fun evalRPN() {
        with(EvaluateReversePolishNotation()) {
            test(9, arrayOf("2", "1", "+", "3", "*"))
            test(6, arrayOf("4", "13", "5", "/", "+"))
            test(22, arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"))
        }
    }

    private fun EvaluateReversePolishNotation.test(expected: Int, tokens: Array<String>) {
        assertEquals(expected, evalRPN(tokens))
    }
}