package chap11

import kotlin.contracts.contract

/**
 * 문제 : 주어진 람다 식을 여러 번 실행하고 싶다
 * 해법 : 코틀린 내장 repeat 함수를 사용한다
 *
 * 설명 : repeat 함수는 코틀린 표준 라이브러리에 들어 있다. repeat 함수는 반복할 횟수를 나타내는 정수와 실행할
 * (Int) -> Unit 형식의 함수, 이 두가지를 인자로 받는 inline 함수다.
 */

// repeat 함수의 정의
//@kotlin.internal.InlineOnly
/*
public inline fun repeat(times: Int, action: (Int) -> Unit) {
    contract { callsInPlace(action) }
    for (index in 0 until times) {
        action(index)
    }
}*/

fun main() {
    repeat(5){
        println("Counting : $it")
    }
}