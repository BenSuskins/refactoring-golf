package hole6

class Money private constructor(val value: Int, val currency: String) {
    fun plus(other: Money): Money {
        if (other.currency != currency) {
            throw Incalculable()
        }
        return money(value + other.value, other.currency)
    }

    fun minus(other: Money): Money {
        if (currency != other.currency) {
            throw Incalculable()
        }
        return money(value - other.value, currency)
    }

    companion object {
        fun money(value: Int, currency: String): Money {
            return Money(value, currency)
        }
    }
}
