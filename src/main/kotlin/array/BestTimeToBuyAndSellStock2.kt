package array

class BestTimeToBuyAndSellStock2 {
    fun maxProfit(prices: IntArray): Int {
        var localMin = -1
        var localMax = -1
        var result = 0

        prices.forEach {
            if (localMin == -1 || (localMax == -1 && it < localMin)) {
                localMin = it
            } else if (it > localMax) {
                localMax = it
            } else {
                result += localMax - localMin
                localMin = it
                localMax = -1
            }
        }

        if (localMax > 0) {
            result += localMax - localMin
        }

        return result
    }
}