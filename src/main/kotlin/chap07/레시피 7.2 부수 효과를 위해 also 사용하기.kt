package chap07

import java.util.logging.Logger

/**
 * 문제 : 코드 흐름을 방해하지 않고 메시지를 출력하거나 다른 부수 효과를 생성하고 싶다
 * 해법 : also 함수를 사용해 부수 효과를 생성하는 동작을 수행한다
 * 설명 : also 함수는 코틀린 표준 라이브러리에 있는 확장함수다
 *
 * also 확장 함수
 * public inline fun <T> T.also(
 *  block: (T) -> Unit
 * ): T
 *
 */


fun main() {

    // also는 일반적으로 객체에 함수 호출을 연쇄시키기 위해 사용된다
    val book = createBook()
        .also{ println(it) }
        .also { Logger.getAnonymousLogger().info(it.toString()) }
}

fun createBook() : Map<String,String> {
    return mapOf("suspense" to "sherlock")
}