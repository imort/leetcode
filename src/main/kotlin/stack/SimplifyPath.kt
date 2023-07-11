package stack

import java.util.*

/**
 * Given a string path, which is an absolute path (starting with a slash '/')
 * to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
 *
 * In a Unix-style file system, a period '.' refers to the current directory,
 * a double period '..' refers to the directory up a level,
 * and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'.
 * For this problem, any other format of periods such as '...' are treated as file/directory names.
 *
 * The canonical path should have the following format:
 *
 * The path starts with a single slash '/'.
 * Any two directories are separated by a single slash '/'.
 * The path does not end with a trailing '/'.
 * The path only contains the directories on the path from the root directory
 * to the target file or directory (i.e., no period '.' or double period '..')
 *
 * Return the simplified canonical path.
 */
class SimplifyPath {
    fun simplifyPath(path: String): String {
        val stack = Stack<String>()
        val sb = StringBuilder()

        fun maybeProcessNode() {
            if (sb.isNotEmpty()) {
                when (val node = sb.toString()) {
                    "." -> Unit
                    ".." -> while (stack.size > 1) if (stack.pop() != "/") break
                    else -> stack.push(node)
                }
                sb.clear()
            }
        }

        for (char in path) {
            when (char) {
                '/' -> {
                    maybeProcessNode()
                    if (stack.isEmpty() || stack.peek() != "/") stack.push("/")
                }

                else -> {
                    sb.append(char)
                }
            }
        }
        maybeProcessNode()
        when {
            stack.isEmpty() -> stack.push("/")
            stack.size > 1 && stack.peek() == "/" -> stack.pop()
        }

        while (stack.isNotEmpty()) {
            sb.insert(0, stack.pop())
        }
        return sb.toString()
    }
}