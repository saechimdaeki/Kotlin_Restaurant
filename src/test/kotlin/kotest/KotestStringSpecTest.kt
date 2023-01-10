package kotest

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeInRange

class KotestStringSpecTest : StringSpec({

    "stringSpecTest1" {
        shouldThrow<RuntimeException> { throwError() }

        "saechim".length shouldBeInRange IntRange(0,9)
    }
}) {

    companion object {
        fun throwError() {
            throw RuntimeException("런타임 ex")
        }
    }
}