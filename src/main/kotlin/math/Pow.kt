package math

import kotlin.math.abs

class Pow {
    fun myPow(x: Double, n: Int): Double {
        return when {
            n == 0 -> 1.0
            x == 1.0 -> 1.0
            x == -1.0 -> if (n % 2 == 0) 1.0 else -1.0
            n > Int.MAX_VALUE / 10 || n < Int.MIN_VALUE / 10 -> 0.0
            else -> {
                var base: Double = x
                var power: Long = n.toLong()
                if (power < 0) {
                    base = 1.0 / base
                    power = abs(power)
                }
                var result = base
                for (i in 1 until power) {
                    result *= base
                }
                result
            }
        }
    }
}