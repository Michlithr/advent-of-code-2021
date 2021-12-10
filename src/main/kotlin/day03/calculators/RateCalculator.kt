package day03.calculators

abstract class RateCalculator {
    var binaryRate: String = ""

    abstract fun calculateRate(report: List<String>): Int

    fun getDecimalRateValue(): Int {
        return binaryRate.toInt(2)
    }

    fun transformFromOtherRate(rate: String): Int  {
        rate.forEach {
            when (it) {
                '0' -> this.binaryRate += '1'
                '1' -> this.binaryRate += '0'
            }
        }

        return this.getDecimalRateValue()
    }
}