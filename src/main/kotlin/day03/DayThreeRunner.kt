package day03

import day03.calculators.EpsilonRateCalculator
import day03.calculators.GammaRateCalculator
import java.io.File
import java.io.FileNotFoundException

fun runDayThree(filePath: String) {
    try {
        val positionsList = File(filePath).readLines()
        val gammaRateCalculator = GammaRateCalculator()
        val epsilonRateCalculator = EpsilonRateCalculator()
        val gammaRate = gammaRateCalculator.calculateRate(positionsList)
        val epsilonRate = epsilonRateCalculator.transformFromOtherRate(gammaRateCalculator.binaryRate)

        println(gammaRate * epsilonRate)
    } catch (e: FileNotFoundException) {
        println("The file path is incorrect. Please, provide a correct path to the input file.")
    }
}