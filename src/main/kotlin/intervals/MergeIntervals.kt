package intervals

import kotlin.math.max

class MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortWith { o1, o2 -> o1[0] - o2[0] }
        val result = mutableListOf<IntArray>()
        var interval = intervals[0]
        var index = 1
        while (index < intervals.size) {
            val current = intervals[index]
            if (current[0] <= interval[1]) {
                interval[1] = max(interval[1], current[1])
            } else {
                result += interval
                interval = current
            }
            index++
        }
        result += interval
        return result.toTypedArray()
    }
}