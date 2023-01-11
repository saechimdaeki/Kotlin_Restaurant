package chap13

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * 문제 : I/O 또는 다른 작업을 위한 전용 스레드 풀을 사용해야 한다.
 * 해법 : Dispatchers 클래스에서 적당한 디스패처를 사용한다
 * 설명 : 코루틴은 CoroutineContext 타입의 컨텍스트 내에서 실행된다. 코루틴 컨텍스트에는 CoroutineDispatcher 클래스의
 * 인스턴스에 해당하는 코루틴 디스패처가 포함돼 있다. 이 디스패처는 코루틴이 어떤 스레드 또는 스레드 풀에서 코루틴을 실행할지 결정한다.
 * launch 또는 async 같은 빌더를 사용할 때 CoroutineContext 선택 파라미터를 통해 사용하고 싶은 디스패처를 명시할 수 있다.
 * 코틀린 표준 라이브러리에는 다음과 같은 내장 디스패처가 들어있다
 * - Dispatchers.Default
 * - Dispatchers.IO
 * - Dispatchers.Unconfined
 *
 * 마지막 디스패처는 일반적으로 애플리케이션 코드에서 사용해서는 안된다. 기본 디스패처는 평범한 공유 백그라운드 스레드 풀을 사용한다. 기본 디스패처 사용은
 * 코루틴이 대규모의 계산 리소스를 소모하는 경우에 적합하다. IO 디스패처는 파일 I/O 또는 블로킹 네트워크 I/O 같은 I/O 집약적인
 * 블로킹 작업을 제거하기 위해 디자인된 생성된 스레드 주문식 공유 풀을 사용한다.
 *
 * 두 디스패처 모두 사용하기 쉽다. 필요에 따라 launch, async, withContext의 인자로 추가하기만 하면 된다.
 */

// 기본 디스패처와 I/O 디스패처 사용하기
fun main() = runBlocking {
    launchWithIO()
    launchWithDefault()
}

suspend fun launchWithIO() {
    withContext(Dispatchers.IO) {
        delay(100L)
        println("Using Dispatchers.IO")
        println(Thread.currentThread().name)
    }
}
suspend fun launchWithDefault() {
    withContext(Dispatchers.Default) {
        delay(100L)
        println("Using Dispatchers.Default")
        println(Thread.currentThread().name)
    }
}