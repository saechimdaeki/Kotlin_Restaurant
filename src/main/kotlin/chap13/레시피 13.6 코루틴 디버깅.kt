package chap13

import kotlinx.coroutines.*

/**
 * 문제 : 코루틴의 실행 정보가 더 많이 필요하다
 * 해법 : JVM에서 -Dkotlinx.coroutines.debug 플래그를 사용해서 실행한다
 *
 * 설명 : 비동기 프로그램의 디버깅은 다수의 작업이 동시에 일어나기 때문에 항상 어렵다. 다행히 코루틴 라이브러리는 쉬운
 * 디버깅 기능이 포함돼 있다. JVM에서 코루틴을 디버그 모드로 실행하려면 kotlinx.coroutines.debug 시스템 속성을 사용하자
 */

// 코루틴에 이름 부여하기
suspend fun retrieve1(url: String) = coroutineScope {
    async(Dispatchers.IO + CoroutineName("async")) { }.await()
}

suspend fun retrieve2(url: String) =
    withContext(Dispatchers.IO + CoroutineName("withContext")) {
        
    }