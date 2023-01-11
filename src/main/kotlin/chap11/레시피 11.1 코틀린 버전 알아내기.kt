package chap11

/**
 * 문제 : 코드를 작성해 현재 사용 중인 코틀린의 버전을 알고 싶다
 * 해법 : KotlinVersion 클래스 동반 객체의 CURRENT 속성을 사용한다
 */

fun main() {
    println("The current Kotlin version is ${KotlinVersion.CURRENT}")
}