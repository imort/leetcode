package dynamic

class ClimbingStairs {
    fun climbStairs(n: Int): Int {
        when {
            n <= 0 -> return 0
            n == 1 -> return 1
        }
        val array = IntArray(n + 1) { 0 }.apply {
            this[1] = 1
            this[2] = 2
        }
        for (i in 3..n) {
            array[i] = array[i - 2] + array[i - 1]
        }
        return array[n]
    }
}