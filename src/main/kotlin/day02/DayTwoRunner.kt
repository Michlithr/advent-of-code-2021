package day02

import java.io.File
import java.io.FileNotFoundException

fun runDayTwo(filePath: String) {
    try {
        val positionsList: List<String> = File(filePath).readLines()
        val positionCalculator = PositionCalculator(positionsList)

        println("Final horizontal value multiplied by final depth value: ${positionCalculator.calculateFinalPosition()}")
    } catch (e: FileNotFoundException) {
        println("The file path is incorrect. Please, provide a correct path to the input file.")
    } catch (e: IllegalFileException) {
        println(e.message)
    }
}