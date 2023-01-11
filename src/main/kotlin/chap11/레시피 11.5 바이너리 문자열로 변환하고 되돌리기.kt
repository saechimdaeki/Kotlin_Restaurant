package chap11

/**
 * 문제 : 숫자를 바이너리 문자열로 변환하거나 바이너리 문자열을 정수로 파싱하고 싶다
 * 해법 : 기저를 인자로 받는 toString 또는 toInt 함수 중복을 사용한다
 *
 * 설명 : StringsKt 클래스에는 Int에 기저를 인자로 받는 인라인 확장 함수 toString이 있다.
 * 또한 이 클래스에는 이를 반대로 수행하는 확장 함수도 String에 들어있다.
 * toString 메서드를 호출하면 정수를 바이너리 문자열로 변환할 수 있다
 *
 * @see Recipe11-5Test
 */