package day01

import java.lang.NumberFormatException

class MeasurementCalculator(measurementList: List<String>) {
    private val measurements: List<String> = measurementList

    fun countSeriesOfIncreasingDepthMeasures(): Int {
        if (measurements.size < 4)
            return 0

        try {
            var result = 0
            var currentVal: Int
            var prevVal = sumUpNextThreeDepthMeasurements(measurements, 0)

            for (i in 1..measurements.size - 3) {
                currentVal = sumUpNextThreeDepthMeasurements(measurements, i)

                if (currentVal > prevVal) result++

                prevVal = currentVal
            }

            return result
        } catch (e: NumberFormatException) {
            throw e
        }
    }

    private fun sumUpNextThreeDepthMeasurements(measurements: List<String>, firstIndex: Int): Int {
        var result = 0

        for (i in firstIndex..firstIndex + 2) {
            try {
                result += measurements[i].toInt()
            } catch (e: NumberFormatException) {
                throw e
            }
        }

        return result
    }
}