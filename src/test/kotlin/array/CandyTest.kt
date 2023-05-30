package array

import org.junit.jupiter.api.Test

class CandyTest {
    @Test
    fun candy() {
        val test = Candy()
        assert(test.candy(intArrayOf(1, 2, 2)) == 4)
    }
}