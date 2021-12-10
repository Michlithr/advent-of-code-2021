package day03.calculators


class CO2RateCalculator : RateCalculator() {
    override fun calculateRate(report: List<String>): Int {
        val epsilonRateCalculator = EpsilonRateCalculator()
        epsilonRateCalculator.calculateRate(report)
        var currentPattern = ""
        val pattern = epsilonRateCalculator.binaryRate
        var reportCopy: List<String> = report.toList()

        var byteIndex = 0

        while (reportCopy.size > 1 && byteIndex < pattern.length) {
            currentPattern += pattern[byteIndex]
            reportCopy = reportCopy.filter { it.startsWith(currentPattern) }
            byteIndex++
        }

        epsilonRateCalculator.binaryRate = reportCopy[0]

        return epsilonRateCalculator.getDecimalRateValue()
    }
}