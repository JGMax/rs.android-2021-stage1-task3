package subtask3

class TelephoneFinder {

    private val keypad = arrayOf(
        arrayOf("1", "2", "3"),
        arrayOf("4", "5", "6"),
        arrayOf("7", "8", "9")
    )

    private fun getNeighbors(n: Int): ArrayList<String> {
        if (n == 0) {
            return arrayListOf("8")
        }
        val neighbors = arrayListOf<String>()
        if (n == 8) {
            neighbors.add("0")
        }
        val y = (n - 1) / 3
        val x = (n - 1) % 3
        for (i in -1..1 step 2) {
            val neighbor = keypad.getOrNull(y + i)?.getOrNull(x) ?: continue
            neighbors.add(neighbor)
        }

        for (i in -1..1 step 2) {
            val neighbor = keypad.getOrNull(y)?.getOrNull(x + i) ?: continue
            neighbors.add(neighbor)
        }
        return neighbors
    }

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number.contains('-')) {
            return null
        }

        val result = arrayListOf<String>()

        number.forEachIndexed { i, c ->
            val neighbors = getNeighbors(c.toString().toInt())
            neighbors.forEach {
                result.add(number.replaceRange(i until i + 1, it))
            }
        }

        return result.toTypedArray()
    }
}
