package chap11

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import kotlin.random.Random
import kotlin.random.nextInt

class `Recipe11-10Test` : BehaviorSpec({

    Given("랜덤한 값이 주어질 때") {
        When("next Int with no args gives any Int") {
            Then("이 안에 값이 있어야 한다") {
                val value = Random.nextInt()
                value shouldBeInRange Int.MIN_VALUE..Int.MAX_VALUE
            }
        }
        When("값이 주어진다면 "){
            Then("이 값 이하로 값이 존재해야한다"){
                val value = Random.nextInt(10)
                value shouldBeInRange 0..10
            }
        }

        When("최솟값과 최댓값 즉 범위가 주어진다면") {
            Then("범위 안에 값이 존재해야한다") {
                val value = Random.nextInt(5,10)
                value shouldBeInRange 5..10
            }
        }

        When("nextInt with range returns value in range") {
            val value = Random.nextInt(7..12)
            value shouldBeInRange 7..12

        }

        When("시드 값과 함께 난수 생성기 사용하기") {
            Then("값들이 검증되어야 함"){
                val r1 = Random(12345)
                val nums1 = (1..10).map { r1.nextInt() }

                val r2 = Random(12345)
                val nums2 = (1..10).map { r2.nextInt() }

                nums1 shouldBe nums2
            }
        }
    }

})