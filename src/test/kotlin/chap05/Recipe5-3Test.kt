package chap05

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame

class `Recipe5-3Test` {

    @Test
    @DisplayName("가변 리스트의 읽기 전용 뷰 생성하기")
    fun readOnly_view_of_a_mutable_list() {
        val mutableNums = mutableListOf(3, 1, 4, 1, 5, 9)
        val readOnlySameList = mutableNums
        assertEquals(mutableNums, readOnlySameList)
        assertSame(mutableNums, readOnlySameList)
        mutableNums.add(2)
        assertEquals(mutableNums, readOnlySameList)
        assertSame(mutableNums, readOnlySameList)
    }
}