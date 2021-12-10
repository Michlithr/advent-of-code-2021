package day03.calculators

class EpsilonRateCalculator : RateCalculator() {
    override fun calculateRate(report: List<String>): Int  {
        val halfOfReportSize = report.size / 2
        val recordLength = report[0].length
        val zerosCounter = IntArray(recordLength)

        report.forEach {
            for (i in 0 until recordLength)
                if (it[i] == '0') zerosCounter[i]++
        }

        zerosCounter.forEach {
            this.binaryRate += if (it <= halfOfReportSize) '0'
            else '1'
        }

        return this.getDecimalRateValue()
    }
}