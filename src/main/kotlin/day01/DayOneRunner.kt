package day01

import java.io.File
import java.io.FileNotFoundException

fun runDayOne(filePath: String) {
    try {
        val measurementList: List<String> = File(filePath).readLines()
        val measurementCalculator = MeasurementCalculator(measurementList)

        println("The number of times the sum of measurements in this sliding window increases from the previous " +
                "measurements: ${measurementCalculator.countSeriesOfIncreasingDepthMeasures()}")
    } catch (e: FileNotFoundException) {
        println("The file path is incorrect. Please, provide a correct path to the input file.")
    } catch (e: NumberFormatException) {
        println("This file can not be processed because it contains incorrect values - it should contains only numbers.")
    }
}