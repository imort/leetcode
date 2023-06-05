package array

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ZigZagConversionTest {
    @Test
    fun convert() {
        with(ZigZagConversion()) {
            test("PAHNAPLSIIGYIR", "PAYPALISHIRING", 3)
            test("PINALSIGYAHRPI", "PAYPALISHIRING", 4)
        }
    }

    private fun ZigZagConversion.test(expected: String, input: String, rows: Int) {
        assertEquals(expected, convert(input, rows))
    }
}