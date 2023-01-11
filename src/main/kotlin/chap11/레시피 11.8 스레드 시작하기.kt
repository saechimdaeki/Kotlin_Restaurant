package chap11

import kotlin.concurrent.thread
import kotlin.random.Random
import kotlin.random.nextLong

/**
 * 문재 : 코드 블록을 동시적 스레드에서 실행하고 싶다
 * 해법 : kotlin.concurrent 패키지의 thread 함수를 사용한다
 *
 * 설명 : 코틀린은 스레드를 쉽게 생성하고 시작할 수 있는 확장 함수 thread를 제공한다 시그니처는 다음과 같다
 *
fun thered(
    start: Boolean = true,
    isDeamon: Boolean = false,
    contextClassLoader: ClassLoader? = null,
    name: String? = null,
    priority: Int = -1,
    block: () -> Unit
): Thread
 */

fun main() {

    //다수의 스레드를 임의의 간격으로 시작하기
    (0..5).forEach { n ->
        val sleepTime = Random.nextLong(range = 0..1000L)
        thread {
            Thread.sleep(sleepTime)
            println("${Thread.currentThread().name} for $n after ${sleepTime}ms")
        }.join()
    }

    // 데몬 스레드 시작하기
    (0..5).forEach { n ->
        val sleepTime = Random.nextLong(range = 0..1000L)
        thread(isDaemon = true) {
            Thread.sleep(sleepTime)
            println("${Thread.currentThread().name} for $n after $sleepTime ms")
        }
    }

    // 여러 스레드 조인하기
    (0..5).forEach { n ->
        val sleepTime = Random.nextLong(range = 0..1000L)
        thread {
            Thread.sleep(sleepTime)
            println("${Thread.currentThread().name} for $n after $sleepTime ms")
        }.join()
    }

}

