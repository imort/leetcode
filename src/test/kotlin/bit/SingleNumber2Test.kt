package bit

import org.junit.jupiter.api.Test

class SingleNumber2Test {
    @Test
    fun singleNumber() {
        val test = SingleNumber2()
        assert(test.singleNumber(intArrayOf(2, 2, 3, 2)) == 3)
        assert(test.singleNumber(intArrayOf(0, 1, 0, 1, 0, 1, 99)) == 99)
    }
}