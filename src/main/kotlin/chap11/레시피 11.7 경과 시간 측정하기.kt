package chap11

import java.util.stream.IntStream
import kotlin.system.measureTimeMillis

/**
 * 문제 : 코드 블록이 실행되는 데 걸린 시간을 알고 싶다
 * 해법 : 코틀린 표준 라이브러리의 measureTimeMillis 또는 measureNanoTime 함수를 사용한다
 *
 * 설명 : kotlin.system 패키지에는 measureTimeMillis와 measureNanoTime 함수가 있다. 이 두함수를 사용하면
 * 다음처럼 코드 블록을 실행하는데 걸린 시간을 측정하는 작업이 쉬워진다
 */

// 코드 블록의 경과 시간 측정하기
fun doubleIt(x: Int): Int {
    Thread.sleep(100L)
    println("doubling $x with on thread ${Thread.currentThread().name}")
    return x * 2
}

fun main() {
    println("${Runtime.getRuntime().availableProcessors()} processors")
    var time = measureTimeMillis {
        IntStream.rangeClosed(1, 6)
            .map { doubleIt(it) }
            .sum()
    }
    println("Sequential stream took $time ms")

    time = measureTimeMillis {
        IntStream.rangeClosed(1, 6)
            .parallel()
            .map { doubleIt(it) }
            .sum()
    }

    println("Parallel stream took $time ms")
}

// measureTimeMillis 함수의 구현
public inline fun measureTimeMillis(block: () -> Unit): Long {
    val start = System.currentTimeMillis()
    block()
    return System.currentTimeMillis() - start
}