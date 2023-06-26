package hashmap

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HappyNumberTest {
    @Test
    fun isHappy() {
        with(HappyNumber()) {
            test(true, 19)
            test(false, 2)
        }
    }

    private fun HappyNumber.test(expected: Boolean, n: Int) {
        assertEquals(expected, isHappy(n))
    }
}