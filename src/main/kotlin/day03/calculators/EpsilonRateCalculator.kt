package day03.calculators

class EpsilonRateCalculator : RateCalculator() {
    override fun calculateRate(report: List<String>): Int  {
        TODO("Not yet implemented")
    }

    override fun transformFromOtherRate(rate: String): Int  {
        rate.forEach {
            when (it) {
                '0' -> this.binaryRate += '1'
                '1' -> this.binaryRate += '0'
            }
        }

        return this.getDecimalRateValue()
    }
}