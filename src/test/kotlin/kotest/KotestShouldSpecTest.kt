package kotest

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class KotestShouldSpecTest : ShouldSpec({

    context("String 길이 비교 ") {
        should("return the length of the string ㅎㅎ") {
            "saechimdaeki".length shouldBe 12
            "".length shouldBe 0
        }
    }

    xcontext("이건 뭐 실행 안되니까"){
        should("adad") {
            "saechimdaeki".length shouldNotBe 12
        }
    }


})