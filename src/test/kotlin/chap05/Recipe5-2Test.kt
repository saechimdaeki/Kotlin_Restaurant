package chap05

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.*

class `Recipe5-2Test` {

    @Test
    @DisplayName("LinkedList 인스턴스화")
    fun instantiating_a_linked_list() {
        val list = LinkedList<Int>()
        list.add(3)
        list.add(1)
        list.addLast(999)
        list[2] = 4
        list.addAll(listOf(1, 5, 9, 2, 6, 5))
        Assertions.assertThat(list).containsExactly(3, 1, 4, 1, 5, 9, 2, 6, 5)
    }
}