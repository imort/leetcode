package bit

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class BitwiseAndOfNumbersRangeTest {
    @Test
    fun rangeBitwiseAnd() {
        val test = BitwiseAndOfNumbersRange()
        assert(test.rangeBitwiseAnd(5, 7) == 4)
        assert(test.rangeBitwiseAnd(0, 0) == 0)
        assert(test.rangeBitwiseAnd(1, 2147483647) == 0)
    }
}