package slidingwindow

/**
 * You are given a string s and an array of strings words.
 * All the strings of words are of the same length.
 *
 * A concatenated substring in s is a substring that contains
 * all the strings of any permutation of words concatenated.
 *
 * For example, if words = ["ab","cd","ef"],
 * then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings.
 * "acdbef" is not a concatenated substring because it is not the concatenation of any permutation of words.
 *
 * Return the starting indices of all the concatenated substrings in s. You can return the answer in any order.
 */
class SubstringWithConcatenationOfAllWords {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        if (s.isEmpty() || words.isEmpty()) return emptyList()
        val wordCount = words.size
        val wordLength = words[0].length
        val substringLength = wordLength * wordCount
        val length = s.length
        if (length < substringLength) return emptyList()
        val trie = ConcatTrie(words)
        val result = mutableListOf<Int>()
        for (i in 0..length - substringLength) {
            if (trie.accept(s, i, wordLength, wordCount)) result += i
        }
        return result
    }

    private class ConcatTrie(words: Array<String>) {
        private val root = Node()

        init {
            root.fill(words)
        }

        fun accept(s: String, index: Int, length: Int, count: Int): Boolean {
            root.reset()
            root.counter = 1
            repeat(count) { wordIndex ->
                if (!root.accept(s, index + wordIndex * length, length)) return false
            }
            return true
        }

        private class Node(
            private var count: Int = 0,
            var counter: Int = 0,
            private val children: MutableMap<Char, Node> = mutableMapOf()
        ) {
            fun fill(words: Array<String>) {
                for (word in words) {
                    var node = this
                    for (char in word) {
                        node = node.children[char] ?: Node().also { node.children[char] = it }
                        node.count++
                    }
                }
            }

            fun reset() {
                if (counter != 0) {
                    counter = 0
                    children.values.onEach(Node::reset)
                }
            }

            fun accept(s: String, index: Int, length: Int): Boolean {
                var node = this
                for (i in index until index + length) {
                    val char = s[i]
                    val child = node.children[char] ?: return false
                    if (++child.counter > child.count) return false
                    node = child
                }
                return true
            }
        }
    }
}