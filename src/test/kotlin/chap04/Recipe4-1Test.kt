package chap04

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigInteger
import kotlin.test.assertEquals

class `Recipe4-1Test` {


    @Test
    @DisplayName("sum 연산의 테스트")
    fun `sum using fold`() {
        val numbers = intArrayOf(3, 1, 4, 1, 5, 9)
        assertEquals(numbers.sum(), sumWithTrace(*numbers))
    }

    @Test
    @DisplayName("fold를 사용해 팩토리얼 구현한 것 테스트")
    fun factorialFoldTest() {
        val factorialValue = factorialFold(10L)
        assertEquals(factorialValue, BigInteger.valueOf(3628800))
    }

    @Test
    @DisplayName("fold를 사용해 구현한 피보나치 수 테스트")
    fun fibonacciFoldTest() {
        val fiboValue = fibonacciFold(5)
        assertEquals(fiboValue, 5)
    }
}