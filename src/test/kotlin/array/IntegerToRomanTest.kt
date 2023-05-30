package array

import org.junit.jupiter.api.Test

class IntegerToRomanTest {
    @Test
    fun intToRoman() {
        val test = IntegerToRoman()
        assert(test.intToRoman(3) == "III")
        assert(test.intToRoman(58) == "LVIII")
        assert(test.intToRoman(1994) == "MCMXCIV")
    }
}