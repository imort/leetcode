package matrix

import org.junit.jupiter.api.Test

class RotateImageTest {

    @Test
    fun rotate() {
        with(RotateImage()) {
            test(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9)
                ),
                arrayOf(
                    intArrayOf(7, 4, 1),
                    intArrayOf(8, 5, 2),
                    intArrayOf(9, 6, 3)
                )
            )
        }
    }

    private fun RotateImage.test(matrix: Array<IntArray>, result: Array<IntArray>) {
        rotate(matrix)
        assert(matrix.contentDeepEquals(result)) { "Got ${matrix.contentDeepToString()}" }
    }
}