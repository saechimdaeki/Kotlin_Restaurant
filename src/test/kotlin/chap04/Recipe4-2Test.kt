package chap04

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class `Recipe4-2Test` {

    @Test
    @DisplayName("reduce로 구현한 sum함수 테스트")
    fun `sum using reduce`() {
        val numbers = intArrayOf(3, 1, 4, 1, 5, 9)
        assertAll(
            { assertEquals(numbers.sum(), sumReduce(*numbers)) },
            { assertThrows<UnsupportedOperationException> { sumReduce() } }
        )
    }
    @Test
    @DisplayName("더하기 전에 값 두배 증가 테스트")
    fun `sumReduceDoublesTest`(){
        val numbers = intArrayOf(1,2,3,4,5,999)
        assertEquals(sumReduceDoubles(*numbers),2027)
    }
}