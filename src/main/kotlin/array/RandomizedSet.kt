package array

import kotlin.random.Random

class RandomizedSet {
    private val data = mutableSetOf<Int>()
    private val random = Random(0)

    fun insert(`val`: Int): Boolean {
        return data.add(`val`)
    }

    fun remove(`val`: Int): Boolean {
        return data.remove(`val`)
    }

    fun getRandom(): Int {
        // this is using iterator and can be improved with mapping to element index
        return data.elementAt(random.nextInt(0, data.size))
    }
}