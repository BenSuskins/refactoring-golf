package hole3

class TakeHomeCalculator(private val percent: Int) {
    fun netAmount(first: Money, vararg rest: Money): Money {
        val monies = listOf(*rest)

        var total = first

        for (next in monies) {
            if (next.currency != total.currency) {
                throw Incalculable()
            }
        }

        for (next in monies) {
            total = Money(total.value + next.value, next.currency)
        }

        val amount = total.value * (percent / 100.0)
        val tax = Money(amount.toInt(), first.currency)

        if (total.currency != tax.currency) {
            throw Incalculable()
        }
        return Money(total.value - tax.value, first.currency)
    }

    class Money(val value: Int, val currency: String)
}
