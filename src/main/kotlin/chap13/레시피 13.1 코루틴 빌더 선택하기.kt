package chap13

import kotlinx.coroutines.*
import kotlin.random.Random


/**
 * 문제 : 코루틴을 생성하는 올바른 함수를 선택해야 한다
 * 해법 : 사용 가능한 빌더 함수 중에 선택한다
 *
 * 설명 : 새 코루틴을 생성하려면 빌더 함수 runBlocking, launch , async 중 하나를 사용할 수 있다.
 * 가장 먼저, runBlocking 빌더 함수는 최상위 함수인 반면 launch와 async는 CoroutineScope의 확장함수다.
 *
 * GlobalScope에 정의된 launch와 async가 완전하게 제거될 것이 아니라면 이를 사용하지 말 것을 권장한다
 * GlobalScope의 launch와 async의 문제점은 시작하는 코루틴이 특정 코루틴 잡에도 할당되지 않고 영구적으로 취소되지
 * 않으면 애플리케이션의 전체 수명주기에 걸쳐 실행된다는 것이다.
 *
 * 따라서 반드시 사용해야 할 이유가 없다면 부디 GlobalScope의 launch와 async를 사용하지 말자
 */

/**
 * runBlocking 빌더
 * runBlocking은 현재 스레드를 블록하고 모든 내부 코루틴이 종료될때까지 블록한다.
 * fun <T> runBlocking(block: suspend CoroutineScope.() -> T): T
 *
 * runBlocking 함수 자체는 suspend 함수가 아니므로 보통 함수에서 호출할 수 있다. runBlocking 함수는 인자로서
 * CoroutineScope에 확장 함수로 추가될 suspend 함수를 받고, 이 인자로 받은 함수를 실행하고, 실행한 함수가 리턴하는 값을 리턴한다
 */

fun useRunBlocking() {
    println("coroutine 생성 전")
    runBlocking {
        println("Hello, ")
        delay(200L)
        println("World! ")
    }
    println("coroutine 끝 ")
}

/**
 * launch 빌더
 *
 * 독립된 프로세스를 실행하는 코루틴을 시작하고, 해당 코루틴에서 리턴값을 받을 필요가 없다면 launch 코루틴 빌더를 사용하자
 * launch 함수는 CoroutineScope의 확장 함수이기 때문에 CoroutineScope이 사용가능한 경우에만 사용할 수 있다.
 * launch 함수는 코루틴 취소가 필요하면 사용할 수 있는 Job인스턴스를 리턴한다 launch 함수의 시그니처는 다음과 같다
 *
 * fun CoroutineScope.launch(
 *  context: CoroutineContext = EmptyCoroutineContext,
 *  start: CoroutineStart = CoroutineStart.DEFAULT,
 *  block: suspend CoroutineScope.() -> Unit
 * ): Job
 *
 * CoroutineContext는 다른 코루틴과 상태를 공유하기 위해 사용한다. CoroutineStart 파라미터는 오직 DEFAULT, LAZY, ATOMIC 또는 UNDISPATCHED값
 * 만이 될 수 있는 열거형 클래스다. 마지막 파라미터로 제공된 람다는 반드시 인자가 없는 일시 중단 함수이고 아무것도 리턴하지 않아야 한다
 */

fun useLaunch() {
    println("blocking 전")
    runBlocking {
        println("launch 전")
        launch {
            print("Hello, ")
            delay(200L)
            print("World! ")
        }
        println("launch 후")
    }
    println("blocking 후")
}


//fun main() {
//    // runBlocking 함수 사용하기
//    useRunBlocking()
//
//    //launch 함수 사용하기
//    useLaunch()
//}



/**
 * async 빌더
 * 값을 리턴해야 하는 경우에는 일반적으로 async빌더를 사용한다. async 빌더도 CoroutineScope의 확장함수이며 시그니처는 다음과 같다
 * fun <T> CoroutineScope.async(
 *  context: CoroutineContext = EmptyCoroutineContext,
 *  start: CoroutineStart = CoroutineStart.DEFAULT,
 *  block: suspend CoroutineScope.() -> T
 * ): Deferred<T>
 *
 * launch 빌더처럼 async의 CoroutineContext와 CoroutineStart 파라미터도 적절한 기본값이있다.
 * 파라미터로서 제공한 일시 중단 함수는 값을 리턴하면 async 함수가 지연(Deferred) 인스턴스로 해당 값을 감싼다
 * Deferred에서 알아야 할 중요한 함수가 생산된 값을 리턴하기 전에 코루틴이 완료될 때까지 기다리는 await다
 */

suspend fun add(x: Int, y: Int): Int {
    delay(Random.nextLong(1000L))
    return x + y
}

//suspend fun main() = coroutineScope {
//    val firstSum = async {
//        println(Thread.currentThread().name)
//        add(2, 2)
//    }
//
//    val secondSum = async {
//        println(Thread.currentThread().name)
//        add(3, 4)
//    }
//    println("concurrent sum 기다리기")
//    val total = firstSum.await() + secondSum.await()
//    println("Total is $total")
//}

// add 함수는 1000밀리초보다 작은 임의의 밀리초 동안 실행이 지연된 다음, 두 수의 합을 리턴한다
// 2개의 async 호출은 add 함수를 호출하고 Deferred인스턴스를 리턴한다. 그런 다음 await 호출은 코루틴이 완료될 때까지 블록한다



/**
 * coroutineScope 빌더
 * 마지막으로 coroutineScope 함수는 종료 전에 포함된 모든 코루틴이 완료될 때까지 기다리는 일시 중단 함수다
 * coroutineScope 함수는 (runBlocking과는 다르게) 메인 스레드를 블록하지 않는 것이 장점이지만 반드시 일시 중단 함수의 일부로서 호출돼야한다
 *
 * 정의된 영역 안에서 코루틴을 사용해야 한다는 코루틴 사용 기본 원칙 중 하나다. coroutineScope의 이점은 코루틴 완료 여부를 확인하기 위해
 * 코루틴을 조사해야 할 필요가 없다는 것이다
 * coroutineScope은 자동으로 모든 자식 코루틴이 완료될 때까지 기다린다. coroutineScope 함수의 시그니처는 다음과 같다
 * suspend fun <R> coroutineScope(
 *  block: suspend CoroutineScope.() -> R
 * ): R
 *
 * coroutineScope 함수는 인자가 없고 제네릭 값을 리턴하는 람다를 받는다. coroutineScope 함수는 일시 중단 함수이기 때문에
 * 반드시 일시 중단 함수 또는 다른 코루틴에서 호출돼야한다
 */

// coroutineScope 빌더 사용 하기
suspend fun main() = coroutineScope {
    for(i in 0 until 10) {
        launch {
            delay(1000L - i * 10)
            print("$i ")
        }
    }
}
