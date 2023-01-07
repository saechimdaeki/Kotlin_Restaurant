package chap05

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class `Recipe5-5Test` {

    @Test
    @DisplayName("값을 범위로 지정하기")
    fun `coerceIn given a range`(){
        val range = 3..8

        assertThat(5).isEqualTo(5.coerceIn(range))
        assertThat(range.first).isEqualTo(1.coerceIn(range))
        assertThat(range.last).isEqualTo(9.coerceIn(range))
    }

    @Test
    @DisplayName("최솟 값과 최대값을 사용해 값을 강제하기 ")
    fun `coerceIn given min and max`(){
        val min = 2
        val max =6

        assertThat(5).isEqualTo(5.coerceIn(min,max))
        assertThat(min).isEqualTo(1.coerceIn(min,max))
        assertThat(max).isEqualTo(9.coerceIn(min,max))
    }
}