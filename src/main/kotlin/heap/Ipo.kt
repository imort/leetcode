package heap

import java.util.*

/**
 * Suppose LeetCode will start its IPO soon.
 * In order to sell a good price of its shares to Venture Capital,
 * LeetCode would like to work on some projects to increase its capital before the IPO.
 * Since it has limited resources, it can only finish at most k distinct projects before the IPO.
 * Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.
 *
 * You are given n projects where the ith project has a pure profit profits[i]
 * and a minimum capital of capital[i] is needed to start it.
 *
 * Initially, you have w capital.
 * When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.
 *
 * Pick a list of at most k distinct projects from given projects to maximize your final capital,
 * and return the final maximized capital.
 *
 * The answer is guaranteed to fit in a 32-bit signed integer.
 */
class Ipo {
    fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
        val capitalQueue = PriorityQueue(compareBy<Project> { it.capital })
        for (i in capital.indices) {
            capitalQueue.offer(Project(capital[i], profits[i]))
        }
        val profitQueue = PriorityQueue(compareByDescending<Project> { it.profit })
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