package chap05

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class `Recipe5-6Test` {

    @Test
    @DisplayName("리스트를 여러 부분으로 나누고, 나눈 부분을 계산하기")
    fun chunked() {
        val range = 0..10

        val chunked = range.chunked(3)
        assertThat(chunked).containsExactly(listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8), listOf(9, 10))
        assertThat(range.chunked(3) { it.sum() }).isEqualTo(listOf(3, 12, 21, 19))
        assertThat(range.chunked(3) { it.average() }).isEqualTo(listOf(1.0, 4.0, 7.0, 9.5))
    }

    @Test
    @DisplayName("각 윈도우의 이동 평균 계산하기")
    fun windowed() {
        val range = 0..10

        assertThat(range.windowed(3, 3)).containsExactly(listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8))

        assertThat(range.windowed(3, 3) { it.average() }).containsExactly(1.0, 4.0, 7.0)

        assertThat(range.windowed(3, 1)).containsExactly(
            listOf(0, 1, 2), listOf(1, 2, 3), listOf(2, 3, 4),
            listOf(3, 4, 5), listOf(4, 5, 6), listOf(5, 6, 7), listOf(6, 7, 8), listOf(7, 8, 9), listOf(8, 9, 10)
        )
        assertThat(range.windowed(3, 1) { it.average() }).containsExactly(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    }
}