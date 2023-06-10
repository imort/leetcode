package intervals

import kotlin.math.max
import kotlin.math.min

/**
 * There are some spherical balloons taped onto a flat wall that represents the XY-plane.
 * The balloons are represented as a 2D integer array points where
 * points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend.
 * You do not know the exact y-coordinates of the balloons.
 *
 * Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis.
 * A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend.
 * There is no limit to the number of arrows that can be shot.
 * A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
 *
 * Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
 */
class MinArrowsToBurstBalloons {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        if (points.isEmpty()) return 0
        points.sortBy { it[0] }
        val intersected = mutableListOf<IntArray>()
        intersected += points[0]
        for (i in 1 until points.size) {
            val interval = points[i]
            if (!intersected.last().intersectSorted(interval)) intersected += interval
        }
        return intersected.size
    }

    private fun IntArray.intersectSorted(other: IntArray): Boolean {
        if (other[0] <= this[1]) {
            this[0] = max(this[0], other[0])
            this[1] = min(this[1], other[1])
            return true
        }
        return false
    }
}