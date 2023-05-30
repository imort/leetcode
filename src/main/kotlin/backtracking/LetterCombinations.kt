package backtracking

class LetterCombinations {
    private val map = mapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )

    fun letterCombinations(digits: String): List<String> {
        val size = digits.length
        if (size == 0) return emptyList()

        val sizes = IntArray(size) { map[digits[it]]!!.length }
        val indexes = IntArray(size) { 0 }

        fun construct(): String {
            val sb = StringBuilder()
            for (i in 0 until size) sb.append(map[digits[i]]!![indexes[i]])
            return sb.toString()
        }

        val result = mutableListOf<String>()
        val n = sizes.fold(1) { acc, next -> acc * next }
        for (i in 0 until n) {
            result += construct()
            var j = size - 1
            while (j >= 0) {
                val index = indexes[j]
                if (index < sizes[j] - 1) {
                    indexes[j]++
                    break
                }
                indexes[j] = 0
                j--
            }
        }
        return result
    }
}