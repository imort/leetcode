package heap

import java.util.*

class Ipo {
    fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
        val capitalQueue = PriorityQueue(Comparator<Project> { o1, o2 -> o1.capital - o2.capital })
        for (i in capital.indices) {
            capitalQueue.offer(Project(capital[i], profits[i]))
        }
        val profitQueue = PriorityQueue(Comparator<Project> { o1, o2 -> o2.profit - o1.profit })
        var gains = w
        repeat(k) {
            while (capitalQueue.isNotEmpty() && capitalQueue.peek().capital <= gains) {
                profitQueue.offer(capitalQueue.poll())
            }
            if (profitQueue.isEmpty()) return@repeat
            gains += profitQueue.poll().profit
        }
        return gains
    }

    class Project(val capital: Int, val profit: Int)
}