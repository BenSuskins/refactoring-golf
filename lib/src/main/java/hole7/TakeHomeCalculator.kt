package hole7

class TakeHomeCalculator(private val taxRate: TaxRate) {
    fun netAmount(first: Money, vararg rest: Money): Money {
        val total = listOf(*rest).foldRight(first) { a: Money, e: Money -> a.plus(e) }
        val tax = taxRate.apply(total)
        return total.minus(tax)
    }
}
