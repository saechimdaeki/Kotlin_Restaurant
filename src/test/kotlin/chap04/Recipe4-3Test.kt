package chap04

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import java.math.BigInteger

class `Recipe4-3Test` {

    @Test
    @DisplayName("재귀 팩토리얼 구현 테스트")
    fun `check recursive factorial`() {
        assertAll(
            { assertThat(recursiveFactorial(0)).isEqualTo(BigInteger.ONE) },
            { assertThat(recursiveFactorial(1)).isEqualTo(BigInteger.ONE) },
            { assertThat(recursiveFactorial(2)).isEqualTo(BigInteger.valueOf(2)) },
            { assertThat(recursiveFactorial(5)).isEqualTo(BigInteger.valueOf(120)) },
            { assertThrows<StackOverflowError> { recursiveFactorial(20_000) }}
        )
    }

    @Test
    @DisplayName("꼬리 재귀 구현 테스트")
    fun `factorial tests`() {
        assertAll(
            { assertThat(factorial(0)).isEqualTo(BigInteger.ONE) },
            { assertThat(factorial(1)).isEqualTo(BigInteger.ONE) },
            { assertThat(factorial(2)).isEqualTo(BigInteger.valueOf(2)) },
            { assertThat(factorial(5)).isEqualTo(BigInteger.valueOf(120)) },
            { assertThat(factorial(15000).toString().length).isEqualTo(56130) },
            { assertThat(factorial(75000).toString().length).isEqualTo(333061) }
        )
    }
}