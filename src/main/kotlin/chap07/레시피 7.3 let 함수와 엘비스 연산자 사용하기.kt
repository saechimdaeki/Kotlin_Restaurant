package chap07

/**
 * 문제 : 오직 널이 아닌 레퍼런스 코드 블록을 실행하고 싶지만 레퍼런스가 널이라면 기본값을 리턴하고 싶다
 * 해법 : 엘비스 연산자를 결합한 안전 호출 연산자와 함께 let 영역 함수를 사용하자
 * 설명 : let 함수는 모든 제네릭 타입 T의 확장함수다.
 *
 * 표준 라이브러리 내의 let 함수의 구현
 *
 * public inline fun <T, R> T.let(
 *  block: (T) -> R
 * ): R
 */

// 문자열 대문자 변경과 특수한 입력 처리
fun processingString(str: String) =
    str.let {
        when {
            it.isEmpty() -> "Empty"
            it.isBlank() -> "Blank"
            else -> it.capitalize()
        }
    }

/**
 * capitalize 함수를 호출하지만 빈 문자 또는 공백 문자의 경우에는 capitalize 함수는
 * 쓸모 없는 데이터를 돌려준다. let 함수는 내부 블록에서 when 조건을 감싸 필요한 모든
 * 경우를 처리하고 변환된 문자열을 돌려준다
 */

// 같은 처리지만 널이 될 수 있는 문자열
fun processNullableString(str: String?) =
    str?.let {
        when {
            it.isEmpty() -> "Empty"
            it.isBlank() -> "Blank"
            else -> it.capitalize()
        }
    } ?: "Null"