package stack

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BasicCalculatorTest {
    @Test
    fun calculate() {
        with(BasicCalculator()) {
//            test(2, "1 + 1")
//            test(3, " 2-1 + 2 ")
//            test(23, "(1+(4+5+2)-3)+(6+8)")
//            test(-1, "-1")
//            test(0, "-(2- 3+ 1)")
            test(2147483647, "2147483647")
        }
    }

    private fun BasicCalculator.test(expected: Int, s: String) {
        assertEquals(expected, calculate(s))
    }
}