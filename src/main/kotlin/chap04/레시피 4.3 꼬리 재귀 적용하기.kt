package chap04

import java.math.BigInteger

/*
문제 : 재귀 프로세스를 실행하는 데 필요한 메모리를 최소화하고 싶다
해법 : 꼬리 재귀를 사용해 프로세스 알고리즘을 표현하고 해당 함수에 tailrec 키워드를 추가한다
*/


// 재귀 함수로 팩토리얼 구현
fun recursiveFactorial(n: Long): BigInteger =
    when (n) {
        0L, 1L -> BigInteger.ONE
        else -> BigInteger.valueOf(n) * recursiveFactorial(n - 1)
    }

// 꼬리 호출 알고리즘을 사용하는 팩토리얼 구현
// tailrec 키워드는 컴파일러에게 해당 재귀호출을 최적화해야한다고 알려준다
@JvmOverloads
tailrec fun factorial(n: Long, acc: BigInteger = BigInteger.ONE): BigInteger =
    when (n) {
        0L -> BigInteger.ONE
        1L -> acc
        else -> factorial(n - 1, acc * BigInteger.valueOf(n))
    }

// tailrec 변경자를 적용할 수 있는 함수의 자격 요건은 다음과 같다
// 해당 함수는 반드시 수행하는 마지막 연산으로서 자기 자신을 호출해야 한다
// try/catch/finally 블록 안에서는 tailrec을 사용할 수 없다
// 오직 JVM백엔드에서만 꼬리 재귀가 지원된다



