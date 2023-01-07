package chap05

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class `Recipe5-1Test` {

    @Test
    @DisplayName("배열의 적법한 인덱스 값 획득하기")
    fun `valid indices`() {
        val strings = arrayOf("this", "is", "an", "array", "of", "strings")
        val indices = strings.indices
        Assertions.assertThat(indices).containsExactly(0, 1, 2, 3, 4, 5)
    }

    @Test
    @DisplayName("withIndex를 사용해 배열 값에 접근하기")
    fun `withIndex returns IndexValues`(){
        val strings = arrayOf("this", "is", "an", "array", "of", "strings")
        for((index,value) in strings.withIndex()) {
            println("Index $index maps to $value")
            assertTrue(index in 0..5)
        }
    }
}