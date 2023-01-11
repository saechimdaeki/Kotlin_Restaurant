package chap13

import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * 문제 : 코루틴을 사용하는 사용자 정의 스레드 풀을 제공하고 싶다
 * 해법 : 자바 ExecutorService의 asCoroutineDispatcher 함수를 사용한다
 */

// 코루틴 디스패처로서 스레드 풀 사용하기
fun main()  = runBlocking {
    val dispatcher = Executors.newFixedThreadPool(10)
        .asCoroutineDispatcher()

    withContext(dispatcher) {
        delay(100L)
        println(Thread.currentThread().name)
    }

    dispatcher.close()

    // 스레드 풀 종료하기
    val pool = Executors.newFixedThreadPool(10)
    withContext(pool.asCoroutineDispatcher()){

    }
    pool.shutdown()

    // use 를 사용해서 디스패처 닫기
    Executors.newFixedThreadPool(10).asCoroutineDispatcher().use {
        withContext(it){
            delay(100L)
            println(Thread.currentThread().name)
        }
    }
}