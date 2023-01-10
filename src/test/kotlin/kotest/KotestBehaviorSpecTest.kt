package kotest

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class KotestBehaviorSpecTest : BehaviorSpec({
    val userRepository = UserRepository()
    val userService = mockk<UserService>()

    every { userService.awesomeLogic("saechimdaeki",any()) } returns User("saechimdaeki",20)

    Given("회원가입을 진행하려 할 때") {
        When("나이가 주어진다면") {
            Then("나이가 1살보다 어리면 예외가 발생한다") {
                shouldThrow<RuntimeException> { userRepository.createUser("saechimdaeki", -1) }
            }
            Then("나이가 1살 이상이면 예외가 발생하지 않는다") {
                shouldNotThrow<RuntimeException> { userRepository.createUser("saechimdaeaki", 28) }
            }

            Then("mockk mocking Test") {
                val awesomeLogic = userService.awesomeLogic("saechimdaeki", 123123)

                awesomeLogic.age shouldBe 20

                verify(exactly = 0) { userService.awesomeLogic("saechimdaeki", 123) }
            }
        }
    }
})


class UserRepository {
    fun createUser(name: String, age: Int): User {
        if (age < 1) throw RuntimeException("나이가 잘못된 것 같습니다")
        return User(name, age)
    }
}

class UserService {
    fun awesomeLogic(name: String,age: Int): User {
        // 매우 복잡한 로직이라고 가정하자
        println("======매우 복잡한 로직 수행중 ====")

        runBlocking {
            launch {
                delay(3000L)
            }
        }
        return User(name, age)
    }
}

data class User(
    val name: String,
    val age: Int,
)