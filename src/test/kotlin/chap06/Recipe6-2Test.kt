package chap06

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class `Recipe6-2Test` {

    @ParameterizedTest(name = "{0} is prime and less than 20")
    @ValueSource(ints = [2, 3, 5, 7, 11, 13, 17, 19])
    fun prime_less_tan_20(n: Int) {
        assertTrue(n.isPrime())
    }

    @ParameterizedTest(name = "{0} is composite and less than or equal to 20")
    @ValueSource(ints = [4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20])
    fun compositesLessThanOrEqual20(n: Int) {
        assertFalse(n.isPrime())
    }
}