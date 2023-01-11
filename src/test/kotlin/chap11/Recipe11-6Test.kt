package chap11

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class `Recipe11-6Test` {

    val request = AstroRequest()

    @Test
    @DisplayName("실행 가능한 클래스 사용하기")
    fun getPeople() {
        val result = request()
        assertThat(result.message).isEqualTo("success")
        assertThat(result.number.toInt()).isGreaterThan(0)
        assertThat(result.people.size).isEqualTo(result.number.toInt())
    }
}