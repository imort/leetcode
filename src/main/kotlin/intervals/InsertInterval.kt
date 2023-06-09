package intervals

import kotlin.math.max
import kotlin.math.min

/**
 * You are given an array of non-overlapping intervals intervals where
 * intervals[i] = [starti, endi] represent the start and the end of the ith interval and
 * intervals is sorted in ascending order by starti.
 * You are also given an interval newInterval = [start, end] that represents
 * the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and
 * intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 */
class InsertInterval {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = mutableListOf<IntArray>()

        var start = newInterval[0]
        var end = newInterval[1]

        var counter = 0

        while (counter < intervals.size && intervals[counter][1] < start) {
            result += intervals[counter++]
        }

        while (counter < intervals.size && intervals[counter][0] <= end) {
            val interval = intervals[counter]
            start = min(interval[0], start)
            end = max(interval[1], end)
            counter++
        }
        result += intArrayOf(start, end)

        while (counter < intervals.size) {
            result += intervals[counter++]
        }

        return result.toTypedArray()
    }
}