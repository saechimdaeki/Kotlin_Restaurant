package kotest

import io.kotest.core.spec.Spec
import io.kotest.core.spec.style.FreeSpec
import io.kotest.core.test.TestCase
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldBe

class KotestFreeSpecTest : FreeSpec() {
    override suspend fun beforeSpec(spec: Spec) {
        println("beforeSpec")
    }

    override fun beforeTest(f: suspend (TestCase) -> Unit) {
        println("beforeTest")
    }

    override suspend fun beforeContainer(testCase: TestCase) {
        println("beforeContainer")
    }

    override suspend fun beforeEach(testCase: TestCase) {
        println("beforeEach")
    }

    override suspend fun beforeAny(testCase: TestCase) {
        println("beforeAny")
    }

    init {
        "saechim container" - {
            "simple Test 1" {
                println("simpleTest1")
                "".length shouldBe 0
            }

            "simple Test 2"{
                println("simpleTest2")
                3+5 shouldBe 8
                "saechimdaeki".length shouldBeGreaterThan 3
            }
        }
    }
}