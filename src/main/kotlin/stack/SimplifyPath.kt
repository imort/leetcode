package stack

import java.util.*

class SimplifyPath {
    fun simplifyPath(path: String): String {
        val stack = Stack<String>()
        val sb = StringBuilder()

        fun maybeProcessNode() {
            if (sb.isNotEmpty()) {
                when (val node = sb.toString()) {
                    "." -> Unit
                    ".." -> while (stack.size > 1) {
                        if (stack.pop() != "/") break
                    }

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