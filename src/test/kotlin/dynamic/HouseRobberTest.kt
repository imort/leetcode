package dynamic

import org.junit.jupiter.api.Test

class HouseRobberTest {

    @Test
    fun rob() {
        val test = HouseRobber()
        assert(test.rob(intArrayOf(1, 2, 3, 1)) == 4)
        assert(test.rob(intArrayOf(2, 7, 9, 3, 1)) == 12)
        assert(test.rob(intArrayOf(2, 1, 1, 2)) == 4)
    }
}