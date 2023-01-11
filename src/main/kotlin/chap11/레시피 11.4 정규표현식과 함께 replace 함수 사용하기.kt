package chap11

import java.util.*

/**
 * 문제 : 부분 문자열의 모든 인스턴스를 어떤 값으로 교체하고 싶다
 * 해법 : 문자열 인자 또는 정규식을 받도록 중복된 String의 replace 함수를 사용한다
 * 설명 : String 클래스는 CharSequence 인터페이스를 구현한다. String 클래스에 두 가지 버전의 replace 함수가 정의된다는 의미다
 * // 두 개가 중복된 replace 함수
fun String.replace(
oldValue: String,
newValue: String,
ignoreCase: Boolean = false
): String

fun CharSequence.replace(
regex: Regex,
replacement: String
): String

 *
 *  - replace 함수는 첫 번째 항목이 아니라 발생하는 모든 항목을 교체한다. 자바에서 동일한 메소드는 replaceAll이다.
 *  - 첫 번째 인자로 문자열을 받는 replace 중복은 인자로 받은 문자열을 정규표현식으로 해석하지 않는다.
 *  자바의 메소드 동작과는 다르다. 인자로 전달한 문자열이 정규표현식으로 해석되길 원한다면 먼저 해당 문자열을 toRegex함수를 사용해서 반환하라
 */

// 자바 스타일로 작성한 회문 확인 함수
fun isPal(string: String): Boolean {
    val testString = string.lowercase(Locale.getDefault()).replace("""[\W+]""".toRegex(), "")
    return testString == testString.reversed()
}


// 코틀린 스타일로 작성한 회문 확인 함수
fun String.isPalindrome() =
    this.lowercase(Locale.getDefault())
        .replace("""[\W+]""".toRegex(), "")
        .let { it == it.reversed() }