package chap11

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals

class `Recipe11-4Test` {

    @Test
    @DisplayName("중복된 두 가지 replace 사용하기")
    fun demonStrateReplace() {
        assertAll(
            { assertEquals("one*two*", "one.two.".replace(".", "*")) },
            { assertEquals("********", "one.two.".replace(".".toRegex(), "*")) }
        )
    }
}