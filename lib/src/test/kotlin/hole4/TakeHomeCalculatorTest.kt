package hole4

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class TakeHomeCalculatorTest {
    @Test
    fun canCalculateTax() {
        val first = TakeHomeCalculator(10).netAmount(
            TakeHomeCalculator.Money(40, "GBP"),
            TakeHomeCalculator.Money(50, "GBP"),
            TakeHomeCalculator.Money(60, "GBP")
        ).value
        assertEquals(135, first)
    }

    @Test
    fun cannotSumDifferentCurrencies() {
        assertThrows(Incalculable::class.java) {
            TakeHomeCalculator(10)
                .netAmount(TakeHomeCalculator.Money(4, "GBP"), TakeHomeCalculator.Money(5, "USD"))
        }
    }
}