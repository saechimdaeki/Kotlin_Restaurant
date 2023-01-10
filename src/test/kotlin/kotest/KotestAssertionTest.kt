package kotest

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class KotestAssertionTest : AnnotationSpec() {

    @BeforeEach
    fun beforeTest() {
        println("Before each test")
    }

    @Test
    fun test1() {
        1 shouldBe 1
        3 + 5 shouldBe 8
    }
}