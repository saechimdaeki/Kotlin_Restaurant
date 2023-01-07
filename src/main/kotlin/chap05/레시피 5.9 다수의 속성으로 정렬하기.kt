package chap05

/**
 * 문제 : 클래스를 어떤 속성으로 정렬한 다음, 동일한 값을 다른 속성으로 정렬하는 등, 이처럼 계속해서 클래스를
 * 다수의 속성으로 정렬하고 싶다
 * 해법 : sortedWith와 compareBy 함수를 사용한다
 */
data class Golfer(val score: Int, val first: String, val last: String)

val golfers = listOf(
    Golfer(70, "Jack", "Nicklaus"),
    Golfer(68, "Tom", "Watson"),
    Golfer(68, "saechim", "daeki"),
    Golfer(70, "Tiger", "Woods"),
    Golfer(68, "park", "daeki")
)

fun main() {

    //골프 선수를 점수로 정렬한다음 점수가 같은 성수를 성으로 정렬 마지막으로 점수와 성이 같은 선수를 이름으로 정렬
    val sorted = golfers.sortedWith(compareBy({ it.score }, { it.last }, { it.first }))
    sorted.forEach { println(it) }

    // 이전 비교 후에 새로운 비교를 적용하는 thenBy
    val comaprator = compareBy<Golfer>(Golfer::score)
        .thenBy(Golfer::last)
        .thenBy(Golfer::first)

    golfers.sortedWith(comaprator).forEach(::println)
}

/**
 * 표준 라이브러리의 sortedWith, compareBy함수의 시그니처
fun <T> Iterable<T>.sortedWith(
comparator: Comparator<in T>
): List<T>

fun <T> compareBy(
vararg selectors: (T) -> Comparable<*>?
) : Comparator<T>

compareBy 함수는 Comparator를 생성하고 sortedWith 함수는 Comparator를 인자로 받는다
 */