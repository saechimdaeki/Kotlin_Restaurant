package chap13.`레시피 13`.`2 async`

import kotlinx.coroutines.*

/**
 * 문제 : async로 코루틴을 시작하고 바로 다음에 코루틴이 완료될 동안 기다리는 await 코드를 간소화하고 싶다
 * 해법 : async/await 조합을 withContext로 변경한다
 *
 * 설명 : CoroutineScope 클래스에는 withContext라는 확장 함수도 정의되어 있다. withContext 확장 함수의
 * 시그니처는 다음과 같다
 *
 * suspend fun <T> withContext(
 *  context: CoroutineContext,
 *  block: suspend CoroutineScope.() -> T
 * ): T
 *
 * withContext는 주어진 코루틴 컨텍스트와 함께 명시한 일시적인 블록을 호출하고 완료될 때까지 일시정지한 후에 그 결과를 리턴한다
 * withContext는 async와 바로 다음에 있는 await의 조합을 대체하기 위해 사용하낟
 */

// async와 await를 withContext로 대체하기
suspend fun retrieve1(url:String) = coroutineScope {
    async(Dispatchers.IO) {
        println("Retrieving data on ${Thread.currentThread().name}")
        delay(100L)
        "asyncResults"
    }.await()
}
suspend fun retrieve2(url: String) =
    withContext(Dispatchers.IO) {
        println("Retrieving data on ${Thread.currentThread().name}")
        delay(100L)
        "withContextResults"
    }

fun main()  = runBlocking<Unit> {
    val result1 = retrieve1("www.naver.com")
    val result2 = retrieve2("www.naver.com")
    println("printing result on ${Thread.currentThread().name} $result1")
    println("printing result on ${Thread.currentThread().name} $result2")

}

