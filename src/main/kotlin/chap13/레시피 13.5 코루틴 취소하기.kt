package chap13

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

/**
 * 문제 : 코루틴 내의 비동기 처리를 취소하고 싶다
 * 해법 : launch 빌더 또는 withTimeout이나 withTimeoutOrNull 같은 함수가 리턴하는 Job 레퍼런스를 사용한다
 *
 * 설명 : launch 빌더는 코루틴을 취소하기 위해 사용할 수 있는 Job 타입의 인스턴스를 리턴한다.
 */

fun main() = runBlocking {
    val job = launch {
        repeat(100) { i ->
            println("job: I'm wating $i")
            delay(100L)
        }
    }
    delay(500L)
    println("main: That's enough waiting")
    job.cancel()
    job.join()
    println("main: Done")


    // withTimeout 사용하기
    withTimeout(100L){
        repeat(50){ i ->
            println("job: I'm wating $i")
            delay(100L)
        }
    }
}