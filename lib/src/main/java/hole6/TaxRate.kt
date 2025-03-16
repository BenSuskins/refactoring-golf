package hole6

class TaxRate private constructor(private val percent: Int) {
    fun apply(total: Money): Money {
        val amount = total.value * (percent / 100.0)
        return Money.money(amount.toInt(), total.currency)
    }

    companion object {
        fun taxRate(percent: Int): TaxRate {
            return TaxRate(percent)
        }
    }
}
