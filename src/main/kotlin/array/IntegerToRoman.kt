package array

class IntegerToRoman {
    private val map = mapOf(
        1000 to "M",
        900 to "CM",
        500 to "D",
        400 to "CD",
        100 to "C",
        90 to "XC",
        50 to "L",
        40 to "XL",
        10 to "X",
        9 to "IX",
        5 to "V",
        4 to "IV",
        1 to "I"
    )

    fun intToRoman(num: Int): String {
        val sb = StringBuilder()
        var remainder = num
        for ((key, value) in map.entries) {
           while (remainder >= key) {
               sb.append(value)
               remainder -= key
           }
        }
        return sb.toString()
    }
}