package subtask1

class Combinator {

    private fun Int.factorial(stop: Int = 2) : Long {
        if (this <= 1) {
            return 1
        }
        var result = 1L
        for (i in this downTo stop) {
            result *= i
        }
        return result
    }

    fun checkChooseFromArray(array: Array<Int>): Int? {
        val m = array[0]
        val n = array[1]
        val nFac = array[1].factorial()

        for (x in 1..n) {
            if (m <= nFac/(x.factorial() * (n - x).factorial())) {
                return x
            }
        }
        return null
    }
}
