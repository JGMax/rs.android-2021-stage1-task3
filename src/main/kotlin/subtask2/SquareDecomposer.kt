package subtask2

import kotlin.math.sqrt

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        val targetSum = number * number
        return findDecomposition(targetSum, number - 1)?.toTypedArray()
    }

    private fun findDecomposition(target: Int, limit: Int): ArrayList<Int>? {
        for (i in limit downTo 1) {
            val square = i * i
            if (target - square == 0) {
                return arrayListOf(i)
            }
            if (target - square < 0) {
                return null
            }
            var newLimit = sqrt((target - square).toDouble()).toInt()
            if (newLimit >= i) {
                newLimit = i - 1
            }
            val result = findDecomposition(target - square, newLimit)
            if (result != null) {
                result.add(i)
                return result
            }
        }
        return null
    }
}
