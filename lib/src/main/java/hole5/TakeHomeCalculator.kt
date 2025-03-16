package hole5

class TakeHomeCalculator(private val percent: Int) {
    fun netAmount(first: Money, vararg rest: Money): Money {
        val monies = listOf(*rest)

        var total = first

        for (next in monies) {
            total = total.plus(next)
        }

        val amount = total.value * (percent / 100.0)
        val tax: Money = Money.money(amount.toInt(), first.currency)

        return total.minus(tax)
    }
}
