package chap08

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class `Recipe8-2Test` {

    @Test
    @DisplayName("lazy 초기화 테스트")
    fun lazyUltimateValueTest() {
        assertEquals(42, ultimateAnswer)
    }
}