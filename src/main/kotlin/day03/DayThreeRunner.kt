package day03

import day03.calculators.CO2RateCalculator
import day03.calculators.EpsilonRateCalculator
import day03.calculators.GammaRateCalculator
import day03.calculators.OxygenRateCalculator
import java.io.File
import java.io.FileNotFoundException

fun runDayThree(filePath: String) {
    try {
        val positionsList = File(filePath).readLines()
        solvePowerConsumption(positionsList)
        solveLifeSupport(positionsList)
    } catch (e: FileNotFoundException) {
        println("The file path is incorrect. Please, provide a correct path to the input file.")
    }
}

fun solvePowerConsumption(positionsList: List<String>) {
    val gammaRateCalculator = GammaRateCalculator()
    val epsilonRateCalculator = EpsilonRateCalculator()

    val gammaRate = gammaRateCalculator.calculateRate(positionsList)
    val epsilonRate = epsilonRateCalculator.transformFromOtherRate(gammaRateCalculator.binaryRate)
    val powerConsumption = gammaRate * epsilonRate

    println("Power consumption is equal: $powerConsumption")
}

fun solveLifeSupport(positionsList: List<String>) {
    val oxygenRateCalculator = OxygenRateCalculator()
    val co2RateCalculator = CO2RateCalculator()

    val oxygenRate = oxygenRateCalculator.calculateRate(positionsList)
    val co2Rate = co2RateCalculator.calculateRate(positionsList)
    val lifeSupportRate = oxygenRate * co2Rate

    println("Life support rate is equal: $lifeSupportRate")
}