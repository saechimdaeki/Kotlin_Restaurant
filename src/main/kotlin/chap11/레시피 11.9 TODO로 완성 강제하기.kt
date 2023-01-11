package chap11

/**
 * 문제 : 개발자가 특정 함수나 테스트를 구현을 끝마칠 수 있게 하고 싶다
 * 해법 : 함수 구현을 완성하지 않으면 예외를 던지는 TODO 함수를(선택적 인자 reason과 함께) 사용한다
 * 설명 : 개발자는 종종 어떤 시점에 구현을 완료할 준비가 되지 않은 함수를 완성하기 위해 그들 스스로 메모를 남겨 놓는다
 * 대부분의 언어에서는 다음 예제 처럼 TODO 문을 주석에 추가한다
 *
 * fun myCleverFunction() {
 *  // TODO : 멋진 구현을 찾는 중
 * }
 */

// TODO 함수의 구현
public inline fun TODO(reason: String): Nothing =
    throw NotImplementedError("An operation is not implemented: $reason")

fun main() {
    // 보통의 코드에서 TODO 함수 사용하기
    TODO(reason = "none, really")
}

fun completeThis() {
    TODO()
}