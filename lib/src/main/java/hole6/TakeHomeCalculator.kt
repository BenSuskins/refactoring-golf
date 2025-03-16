package hole6

class TakeHomeCalculator(private val taxRate: TaxRate) {
    fun netAmount(first: Money, vararg rest: Money): Money {
        val monies = listOf(*rest)

        var total = first

        for (next in monies) {
            total = total.plus(next)
        }

        val tax = taxRate.apply(total)
        return total.minus(tax)
    }
}
