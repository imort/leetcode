package graph

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CourseScheduleTest {
    @Test
    fun canFinish() {
        with(CourseSchedule()) {
            test(true, 2, arrayOf(intArrayOf(0, 1)))
            test(false, 2, arrayOf(intArrayOf(0, 1), intArrayOf(1, 0)))
        }
    }

    private fun CourseSchedule.test(expected: Boolean, numCourses: Int, prerequisites: Array<IntArray>) {
        assertEquals(expected, canFinish(numCourses, prerequisites))
    }
}