package chap08

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals

class `Recipe8-4Test` {

    @Test
    @DisplayName(" watched ㅂ젼수 테스트")
    fun watchedValueTest() {
        assertEquals(1, watched)
        watched *= 2
        assertEquals(2, watched)
        watched *= 2
        assertEquals(4, watched)
    }

    @Test
    @DisplayName(" vetoable checked 변수 변경 테스트")
    fun vetoableTest() {
        assertAll(
            { assertEquals(0, checked) },
            { checked = 42; assertEquals(42, checked) },
            { checked = -1; assertEquals(42, checked) },
            { checked = 17; assertEquals(17, checked) }
        )
    }
}