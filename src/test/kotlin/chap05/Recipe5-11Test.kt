package chap05

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.LocalDate

class `Recipe5-11Test` {

    @Test
    @DisplayName("구체적인 타입 사용하기")
    fun specific() {
        // 구체적인 타입 사용하기
        val list = listOf("a", LocalDate.now(), 3, 1, 4, "b")

        val all = list.filterIsInstance<Any>()
        val stringsList = list.filterIsInstance<String>()
        val ints = list.filterIsInstance<Int>()
        val dates = list.filterIsInstance(LocalDate::class.java)

        assertThat(all).isEqualTo(list)
        assertThat(stringsList).containsExactlyInAnyOrder("a", "b")
        assertThat(ints).containsExactlyInAnyOrder(1, 3, 4)
        assertThat(dates).contains(LocalDate.now())
    }

    @Test
    @DisplayName("구체적인 타입을 사용해 제공된 리스트 채우기")
    fun specificMutable() {
        // 구체적인 타입 사용하기
        val list = listOf("a", LocalDate.now(), 3, 1, 4, "b")

        val all = list.filterIsInstanceTo(mutableListOf<Any>())
        val strings = list.filterIsInstanceTo(mutableListOf<String>())
        val ints = list.filterIsInstanceTo(mutableListOf<Int>())
        val dates = list.filterIsInstanceTo(mutableListOf<LocalDate>())
        assertThat(all).isEqualTo(list)
        assertThat(strings).contains("a", "b")
        assertThat(ints).contains(1, 3, 4)
        assertThat(dates).containsExactly(LocalDate.now())
    }
}