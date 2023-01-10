package chap09

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class `Recipe9-4Test` {

    @Test
    @DisplayName("피보나치 함수의 명시적인 호출")
    fun fibonacciExplicit() {
        assertAll(
            { assertThat(fibonacci(4)).isEqualTo(3) },
            { assertThat(fibonacci(9)).isEqualTo(34) },
            { assertThat(fibonacci(2000)).isEqualTo(1392522469) }
        )
    }

    // 다음처럼 CSV 소스를 사용하는 파라미터화된 테스트로 재구성하는 방법도 있다.
    // @CsvSource 애노테이션은 테스트 함수를 위한 입력 데이터로서 문자열 리스트를 인자로 받는다.
    // 각각의 문자열은 해당 함수가 필요한 모든 인자를 제공하며 이 때 인자는 문자열에서 쉼표로 구분된다
    @ParameterizedTest(name = "{0} == {1}")
    @CsvSource(
        "1, 1", "2, 1", "3, 2",
        "4, 3", "5, 5", "6, 8", "7, 13",
        "8, 21", "9, 34", "10, 55"
    )
    fun `first 10 Fibonacci numbers`(n: Int, fib: Int) =
        assertThat(fibonacci(n)).isEqualTo(fib)

    // 파라미터 소스로서 인스턴스 함수에 접근하기

    private fun fibnumbers() = listOf(
        Arguments.of(1, 1), Arguments.of(2, 1),
        Arguments.of(3, 2), Arguments.of(4, 3),
        Arguments.of(5, 5), Arguments.of(6, 8),
        Arguments.of(7, 13), Arguments.of(8, 21),
        Arguments.of(9, 34), Arguments.of(10, 55))

    @ParameterizedTest(name = "fibonacci({0}) == {1}")
    @MethodSource("fibnumbers")
    fun fiboTest(n: Int, fib: Int) {
        assertThat(fibonacci(n)).isEqualTo(fib)
    }

    // 테스트 생명주기가 기본 옵션인 Lifecycle.PER_METHOD라면 다음과 같이 데이터소스 함수를 동반 객체안에 위치시켜야한다

    companion object {

        // Lifecycle.PER_METHOD 생명주기로 파라미터화된 테스트를 하려면 필요
        @JvmStatic
        private fun fibnumbers2() = listOf(
            Arguments.of(1, 1), Arguments.of(2, 1),
            Arguments.of(3, 2), Arguments.of(4, 3),
            Arguments.of(5, 5), Arguments.of(6, 8),
            Arguments.of(7, 13), Arguments.of(8, 21),
            Arguments.of(9, 34), Arguments.of(10, 55))
    }


}