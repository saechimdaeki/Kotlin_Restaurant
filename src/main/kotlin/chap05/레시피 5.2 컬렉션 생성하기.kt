package chap05

/**
문제: 리스트, 세트 또는 맵을 생성하고 싶다
해법: listOf, setOf, mapOf 처럼 변경 불가능한 컬렉션을 생성하기 위해 만들어진 함수나
mutableListOf, mutableSetOf, mutableMapOf처럼 변경 가능한 컬렉션을 생성하기 위해
고안된 함수 중 하나를 사용한다

설명 : 어떤 컬렉션의 변경 불가능한 뷰를 얻고 싶다면 kotlin.collections 패키지가 제공하는 유틸리티 함수를
사용할 수 있다. 한 가지 예를 들면 listOf(vararg elements: T): List<T>가 있다

public fun <T> listOf(vararg elements: T): List<T> =
    if (elements.size > 0) elements.asList() else emptyList()
 */

fun main() {
    // 불변 리스트, 세트, 맵 생성하기
    var numList = listOf(3, 1, 4, 1, 5, 9)
    var numSet = setOf(3, 1, 4, 1, 5, 9)
    var map = mapOf(1 to "one", 2 to "two", 3 to "three")

    // 가변 리스트, 세트 , 맵 생성하기
    var mutableNumList = mutableListOf(3,1,4,1,5,9)
    var mutableNumSet = mutableSetOf(3,1,4,1,5,9)
    var mutableMap = mutableMapOf(1 to "one", 2 to "two", 3 to "three")
}