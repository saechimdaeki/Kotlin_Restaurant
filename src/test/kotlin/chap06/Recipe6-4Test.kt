package chap06

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class `Recipe6-4Test` {

    @Test
    @DisplayName("시퀀스 연산에서 값을 추출하기")
    fun first10Fibonacci() {
        val fibs = fibonacciSequence()
            .take(10)
            .toList()
        assertEquals(listOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34), fibs)
    }
}