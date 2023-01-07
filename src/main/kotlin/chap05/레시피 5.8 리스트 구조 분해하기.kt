package chap05

/**
 * 문제 : 리스트의 원소에 접근할 수 있게 구조분해하고 싶다
 * 해법 : 최대 5개의 원소를 가진 그룹에 리스트를 할당한다
 */

fun main() {
    // 리스트의 원소를 구조 분해하기
    val list = listOf("a", "b", "c", "d", "e", "f", "g")
    val (a, b, c, d, e) = list

    println("$a $b $c $d $e")
}

// List의 component1 확장 함수 (표준 라이브러리)
/**
 * 해당 컬렉션의 첫 번째 *원소*를 리턴한다
 */

public inline operator fun<T> List<T>.component1(): T{
    return get(0)
}