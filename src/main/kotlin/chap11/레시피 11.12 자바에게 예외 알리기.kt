package chap11

import java.io.IOException

/**
 * 문제 : 코틀린 함수가 자바에서 체크 예외(checked exception)차로 여겨지는 예외를 던지는 경우 자바에게
 * 해당 예외가 체크 예외임을 알려주고 싶다
 * 해법 : 함수 시그니처에 @throws 애노테이션을 추가한다
 *
 * 설명 : 코틀린의 모든 예외는 언체크 예외다. 즉 컴파일러는 개발자에게 해당 예외를 처리할 것을 요구하지 않는다.
 * 예외를 붙잡기 위해 코틀린 함수에 try/catch/finally 블록을 추가하는 방법은 아주 쉽지만 강제사항은 아니다
 */

// IOException을 던지는 코틀린 함수
//fun houstonWeHaveAProblem(){
//    throw IOException("ioexception by kotlin")
//}

// 자바에게 이 함수가 IOException을 던진다고 알려줌
@Throws(IOException::class)
fun houstonWeHaveAProblem(){
    throw IOException("ioexception by kotlin")
}