package day03.calculators

class OxygenRateCalculator : RateCalculator() {
    override fun calculateRate(report: List<String>): Int {
        val gammaRateCalculator = GammaRateCalculator()
        gammaRateCalculator.calculateRate(report)
        var currentPattern = ""
        val pattern = gammaRateCalculator.binaryRate
        var reportCopy: List<String> = report.toList()

        var byteIndex = 0

        while (reportCopy.size > 1 && byteIndex < pattern.length) {
            currentPattern += pattern[byteIndex]
            reportCopy = reportCopy.filter { it.startsWith(currentPattern) }
            byteIndex++
        }

        gammaRateCalculator.binaryRate = reportCopy[0]

        return gammaRateCalculator.getDecimalRateValue()
    }
}