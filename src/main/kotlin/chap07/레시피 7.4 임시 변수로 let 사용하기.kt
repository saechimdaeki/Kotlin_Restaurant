package chap07

import com.google.gson.Gson
import java.net.URL

/**
 * 문제 : 연산 결과를 임시 변수에 할당하지 않고 처리하고 싶다
 * 해법 : 연산에 let 호출을 연쇄하고 let에 제공한 람다 또는 함수 레퍼런스 안에서 그 결과를 처리한다
 */

fun main() {
    // 공식 문서에 나온 let 예제, 리팩토링 이전
    val numbers = mutableListOf("one", "two", "three", "four", "five")
    val resultList = numbers.map { it.length }.filter { it > 3 }
    println(resultList)

    println("========")

    //리팩토링 이후 let 사용
    numbers.map { it.length }.filter { it > 3 }.let {
        println(it)
        // 필요하다면 더 많은 함수를 호출
    }

    println("========")

    // let 블록에서 함수 레퍼런스 사용하기
    numbers.map { it.length }.filter { it > 3 }.let(::println)

    println("========")

    // 지금 우주에 있는 우주 비행사의 이름 출력하기
    Gson().fromJson(URL("http://api.open-notify.org/astros.json").readText(),
    AstroResult::class.java)
        .people.map { it.name }.let(::println)

}


data class AstroResult(
    val message: String,
    val number: Number,
    val people: List<Assignment>
)

data class Assignment(
    val craft: String,
    val name: String
)