package graph

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi]
 * indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 */
class CourseSchedule {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        if (numCourses < 2) return true
        val graph = mutableMapOf<Int, MutableSet<Int>>()
        for (prerequisite in prerequisites) {
            val (course, mandatory) = prerequisite
            graph
                .getOrPut(course, ::mutableSetOf)
                .add(mandatory)
        }
        val visited = IntArray(numCourses)
        for (course in 0 until numCourses) {
            if (!dfs(course, graph, visited)) return false
        }
        return true
    }

    private fun dfs(course: Int, graph: Map<Int, Set<Int>>, visited: IntArray): Boolean {
        when (visited[course]) {
            1 -> return false
            2 -> return true
        }
        visited[course] = 1
        val dependencies = graph.getOrDefault(course, emptySet())
        for (dep in dependencies) {
            if (!dfs(dep, graph, visited)) return false
        }
        visited[course] = 2
        return true
    }
}