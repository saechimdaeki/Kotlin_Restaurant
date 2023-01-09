package chap08

import kotlin.properties.Delegates

/**
 * 문제 : 처음 접근이 일너나기 전에 초기화되지 않았다면 예외를 던지고 싶다
 * 해법 : notNull 함수를 이용해, 값이 설정되지 않았다면 예외를 던지는 대리자를 제공한다
 * 설명 : 보통 코틀린 클래스의 속성은 클래스 생성 시에 초기화된다. 속성 초기화를 지연시키는 한 가지 방법은
 * 속성에 처음 접근하기 전에 속성이 사용되면 예외를 던지는 대리자를 제공하는 notNull함수를 사용하는 것이다
 *
 */

// 구체적인 방법을 명시하지 않고 접근 전에 초기화가 필요함

var shouldNotBeNull : String by Delegates.notNull<String>()