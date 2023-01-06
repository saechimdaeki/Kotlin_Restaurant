package chap04

import java.math.BigInteger

/*
문제 : 반복 알고리즘을 함수형 방식으로 구현하고 싶다.
해법: fold 함수를 사용해 시퀀스나 컬렉션을 하나의 값으로 축약시킨다.
설명: fold 함수는 배열 또는 반복 가능한 컬렉션에 적용할 수 있는 축약 연산이다.
inline fun <R> Iterable<T>.fold(
    initial: R,
    operation: (acc: R, T) -> R
): R
*/

// fold를 사용해 정수의 합 계산하기
// 람다 함수의 첫 번째 인자는 누적에 사용되는 값이며 두 번째 인자는 num 리스트의 각각의 값을 순회하며 첫 번째 인자인 누적 값에 순회 중인 n을 더하는 함수
fun sum(vararg nums: Int) =
    nums.fold(0) { acc, n -> acc + n }

// 각각의 값을 출력하는 sum 함수
fun sumWithTrace(vararg nums: Int) =
    nums.fold(0) { acc, n ->
        println("acc = $acc, n = $n")
        acc + n
    }

// fold를 사용해 팩토리얼 구현하기
fun factorialFold(n: Long): BigInteger =
    when (n) {
        0L, 1L -> BigInteger.ONE
        else -> (2..n).fold(BigInteger.ONE) { acc, i ->
            acc * BigInteger.valueOf(i)
        }
    }

// fold를 사용해서 피보나치 수 계산하기

fun fibonacciFold(n: Int) =
    (2 until n).fold(1 to 1) { (prev, curr), _ ->
        curr to (prev + curr)
    }.second

// 더하기 전에 값을 두 배 증가시키기
fun sumReduceDoubles(vararg nums: Int) =
    nums.reduce { acc, i -> acc + 2 * i }