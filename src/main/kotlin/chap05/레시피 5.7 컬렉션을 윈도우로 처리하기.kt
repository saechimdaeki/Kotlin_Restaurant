package chap05

/**
문제 : 값 컬렉션이 주어진 경우 컬렉션을 횡단하는 작은 윈도우를 이용해 컬렉션을 처리하고 싶다
해법 : 컬렉션을 같은 크기로 나누고 싶다면 chunked 함수를 사용하고, 정해진 간격으로 컬렉션을 따라
움직이는 블록을 원한다면 windowed 함수를 사용한다

설명: Iterable 컬렉션에서 chunked함수는 컬렉션을 주어진 크기 또는 그보다 더 작게 리스트의 리스트로 분할한다
chunked 함수는 리스트의 리스트를 리턴할 수 있고 개발자는 chunked 함수의 결과 리스트에 적용할
변환 람다를 제공할 수도 있다

fun <T> Iterable<T>.chunked(size: Int): List<List<T>>

fun <T,R> Iterable<T>.chunked(
    size:Int,
    transform: (List<T>) -> R
): List<R>
 */

// 코틀린 표준 라이브러리의 chunked 구현
public fun <T> Iterable<T>.chunked(size: Int): List<List<T>> {
    return windowed(size, size, partialWindows = true)
}

/**
 * windowed 함수는 세개의 인자를 받고 그중 2개의 인자는 선택사항
 * size - 각 윈도우에 포함될 원소의 개수
 * step - 각 단계마다 전진할 원소의 개수(기본1개)
 * partialWindows - 나뉘어 있는 마지막 부분이 윈도우에 필요한 만큼의 원소 개수를 갖지 못한경우,
 * 해당(=마지막)부분을 그대로 유지할지 여부를 알려주는 불리언 값. 기본값은 false다.
 */
