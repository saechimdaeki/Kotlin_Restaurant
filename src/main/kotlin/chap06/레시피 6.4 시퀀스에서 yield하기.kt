package chap06

/**
 * 문제 : 구간을 지정해 시퀀스에서 값을 생성하고 싶다
 * 해법 : yield 중단 함수와 함께 sequence 함수를 사용하자
 * sequence함수의 시그니처
 * fun <T> sequence(
 *  block: suspend SequenceScope<T>.() -> Unit
 * ): Sequence<T>
 *
 *     sequence 함수는 주어진 블록에서 평가되는 시퀀스를 생성한다. 이 블록은 인자 없는 람다함수이며
 *     void를 리턴하고 평가 후에 SequenceScope 타입을 받는다
 *
 */

// sequence를 사용해 피보나치 수 생성하기
fun fibonacciSequence() = sequence {
    var terms = Pair(0, 1)
    while (true) {
        yield(terms.first)
        terms = terms.second to terms.first + terms.second
    }
}

/**
 * yieldAll은 다수의 값을 이터레이터에 넘겨준다
 * sequence 안의 yieldAll 함수
 * val sequence = sequence {
 *  val start = 0
 *  yield(start)
 *  yieldAll(1..5 step 2)
 *  yieldAll(generateSequence(8) { it * 3})
 * }
 */