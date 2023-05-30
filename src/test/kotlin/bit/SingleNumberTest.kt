package bit

import org.junit.jupiter.api.Test

class SingleNumberTest {
    @Test
    fun singleNumber() {
        val test = SingleNumber()
        assert(test.singleNumber(intArrayOf(2, 2, 1)) == 1)
        assert(test.singleNumber(intArrayOf(4, 1, 2, 1, 2)) == 4)
        assert(test.singleNumber(intArrayOf(1)) == 1)
    }
}