package chap11

/**
 * 문제 : 함수 이름을 읽기 쉽게 작성하고 싶다
 * 해법 : 밑줄을 사용하거나 함수 이름을 백틱으로 감싸 읽기쉽게 만들 수 있다. 하지만 이 기법은 테스트에서만 사용하자
 *
 * 설명: 코틀린은 아래처럼 함수 이름을 백틱으로 감싸는 것을 지원한다
 */


//백틱으로 함수 이름 감싸기
fun `only use backticks on test `(){
    println("테스트에서만 이기능을 쓰자")
}

// 함수 이름에 밑줄 사용하기
fun underscores_are_only_test(){
    println("마찬가지로 테스트때만 이렇게 쓰자")
}

fun main() {
    `only use backticks on test `()
    underscores_are_only_test()
}