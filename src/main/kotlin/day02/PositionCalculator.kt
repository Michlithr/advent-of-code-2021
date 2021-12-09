package day02

import java.lang.NumberFormatException

class PositionCalculator(private val positions: List<String>) {
    fun calculateFinalPosition(): Int {
        var horizontalDistance = 0
        var depthDistance = 0
        var depthAim = 0

        positions.forEach {
            val splittedPosition = it.split(' ')

            if (splittedPosition.size != 2)
                throw IllegalFileException("This file can not be processed because it contains incorrect values - it " +
                        "should contains only pairs 'string number'.")

            try {
                val direction = splittedPosition[0]
                val value = splittedPosition[1].toInt()

                when (direction) {
                    "forward" -> {
                        horizontalDistance += value
                        depthDistance += value * depthAim
                    }
                    "up" ->  depthAim -= value
                    "down" -> depthAim += value
                }
            } catch (e: NumberFormatException) {
                throw IllegalFileException("This file can not be processed because it contains incorrect values - " +
                        "it should contains only pairs 'string number'.")
            }
        }
        return horizontalDistance * depthDistance
    }
}