package chap09

/**
 * 문제 : 데이터 값 세트를 제공해서 Junit5 테스트를 실행하고 싶다
 * 해법 : Junit5의 파라미터화된 테스트와 동적 테스트를 사용한다
 *
 * @See Recipe-9-4Test
 */

@JvmOverloads
tailrec fun fibonacci(n: Int, a: Int = 0, b: Int = 1): Int =
    when (n) {
        0 -> a
        1 -> b
        else -> fibonacci(n - 1, b, a + b)
    }
