package chap06

import kotlin.math.ceil
import kotlin.math.sqrt

/**
 * 문제 : 값으로 이뤄진 시퀀스를 생성하고 싶다
 * 해법 : 이미 원소가 있다면 sequenceOf를 사용하고 Iterable이 있다면 asSequence를 사용한다.
 * 그 외의 경우에는 시퀀스 생성기를 사용한다
 */

fun main() {
    // 값이 있을 때 시퀀스 생성하기
    val numSequence1 = sequenceOf(3, 1, 4, 1, 5, 9)
    val numSequence2 = listOf(3, 1, 4, 1, 5, 9).asSequence()

}

// Int인 숫자가 소수인지 여부 확인하기
fun Int.isPrime() =
    this == 2 || (2..ceil(sqrt(this.toDouble())).toInt())
        .none { divisor -> this % divisor == 0 }

// 주어진 정수 다음에 나오는 소수 찾기
// 주어진 수보다 1 큰 수에서 시작하고 1 증가 반복
// 첫 소수 값을 리턴
fun nextPrime(num: Int) =
    generateSequence(num + 1) { it + 1 }
        .first(Int::isPrime)

