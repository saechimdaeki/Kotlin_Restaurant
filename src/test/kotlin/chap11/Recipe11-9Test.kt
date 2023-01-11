package chap11

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class `Recipe11-9Test` {

    @Test
    @DisplayName("테스트에서 TODO 함수 사용하기")
    fun test() {
        val exception = assertThrows<NotImplementedError> {
            chap11.TODO("seriously, finish this")
        }

        assertEquals("An operation is not implemented: seriously, finish this",exception.message)
    }
}