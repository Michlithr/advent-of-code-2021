package day03.calculators

abstract class RateCalculator {
    var binaryRate: String = ""

    abstract fun calculateRate(report: List<String>): Int
    abstract fun transformFromOtherRate(rate: String): Int

    fun getDecimalRateValue(): Int {
        return binaryRate.toInt(2)
    }
}