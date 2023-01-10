package chap09

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class `Recipe9-5Test` {

    @ParameterizedTest
    @MethodSource("fibonacciTestData")
    fun usingDataClass(data: FibonacciTestData) {
        Assertions.assertThat(fibonacci(data.number)).isEqualTo(data.expected)
    }
    companion object {

        @JvmStatic
        private fun fibonacciTestData() = Stream.of(
            FibonacciTestData(number = 1, expected = 1),
            FibonacciTestData(number = 2, expected = 1),
            FibonacciTestData(number = 3, expected = 2),
            FibonacciTestData(number = 4, expected = 3),
            FibonacciTestData(number = 5, expected = 5),
            FibonacciTestData(number = 6, expected = 8),
            FibonacciTestData(number = 7, expected = 13),
        )
    }
}