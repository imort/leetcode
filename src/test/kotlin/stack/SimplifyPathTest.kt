package stack

import org.junit.jupiter.api.Test

class SimplifyPathTest {
    @Test
    fun simplifyPath() {
        with(SimplifyPath()) {
            test("/home/", "/home")
            test("/../", "/")
            test("/home//foo/", "/home/foo")
            test("/a/./b/../../c/", "/c")
            test("/a//b////c/d//././/..", "/a/b/c")
        }
    }

    private fun SimplifyPath.test(path: String, result: String) {
        val r = simplifyPath(path)
        assert(r == result) { "Got $r" }
    }
}