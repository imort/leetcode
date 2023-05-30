package array

class TextJustification {
    private val SEPARATOR = " "

    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val result = mutableListOf<String>()
        val currentLineWords = mutableListOf<String>()
        var availableSpacePerLine = maxWidth

        words.forEach { word ->
            availableSpacePerLine -= word.length
            when {
                availableSpacePerLine == 0 -> {
                    currentLineWords.add(word)
                    result.add(toLineString(availableSpacePerLine, currentLineWords))

                    currentLineWords.clear()
                    availableSpacePerLine = maxWidth
                }

                availableSpacePerLine < 0 -> {
                    availableSpacePerLine += word.length + 1
                    result.add(toLineString(availableSpacePerLine, currentLineWords))

                    currentLineWords.clear()
                    currentLineWords.add(word)
                    availableSpacePerLine = maxWidth - (word.length + 1)
                }

                else -> {
                    currentLineWords.add(word)
                    availableSpacePerLine--
                }
            }
        }
        if (currentLineWords.isNotEmpty()) {
            result.add(toLineString(availableSpacePerLine + 1, currentLineWords, true))
        }
        return result
    }


    private fun toLineString(
        noOfSpaceToBeDistributed: Int,
        wordsInLine: MutableList<String>,
        isLastLine: Boolean = false
    ): String {
        return if (wordsInLine.size == 1 || isLastLine) {
            wordsInLine.joinToString(SEPARATOR) + SEPARATOR.repeat(noOfSpaceToBeDistributed)
        } else {
            val spaceToBeAddedToAllWords = Math.floorDiv(noOfSpaceToBeDistributed, wordsInLine.lastIndex) + 1
            for (i in 0 until noOfSpaceToBeDistributed % wordsInLine.lastIndex) {
                wordsInLine[i] += SEPARATOR
            }
            wordsInLine.joinToString(SEPARATOR.repeat(spaceToBeAddedToAllWords))
        }
    }
}