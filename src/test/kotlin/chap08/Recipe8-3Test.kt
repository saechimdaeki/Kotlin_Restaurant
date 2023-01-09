package chap08

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class `Recipe8-3Test` {

    @Test
    @DisplayName("초기화 하지 않았으므로 예외가 발생해야함")
    fun shouldOccurException(){
        assertThrows<IllegalStateException>{shouldNotBeNull}
    }

    @Test
    @DisplayName("초기화 하였으므로 에러가 발생하지 않음")
    fun shouldNotOccurException(){
        shouldNotBeNull = "saechimdaeki"
        assertDoesNotThrow { shouldNotBeNull }
        assertEquals("saechimdaeki", shouldNotBeNull)
    }
}