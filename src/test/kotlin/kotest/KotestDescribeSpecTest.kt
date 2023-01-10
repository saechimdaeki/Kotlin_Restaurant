package kotest

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class KotestDescribeSpecTest : DescribeSpec( {

    describe("score"){
        it("start as zero") {
            val scoreCalculate = scoreCalculate(0, 1, 2, 3, 4)
            scoreCalculate shouldBe false
        }

        it("평균이 2보다 낮으면 false") {
            val scoreCalculate = scoreCalculate(0,0,-1,2,3,4,)
            scoreCalculate shouldBe false
        }

        it("평균이 2보다 크면 true") {
            scoreCalculate(1,2,3,4,1,2,6) shouldBe true
        }
    }
}){
    companion object {
        fun scoreCalculate(vararg int :Int) : Boolean{
            when {
                int[0] == 0 -> return false
                else -> {
                    val average = int.average()
                    if (average < 2)
                        return false
                    return true

                }
            }

        }
    }
}
