package chap04
/*
문제: 비어 있지 않은 컬렉션의 값을 축약하고 싶지만 누적자의 초기값을 설정하고 싶지 않다
해법: fold 대신 reduce 연산을 사용한다
설명:
inline fun <S, T : S> Iterable<T>.reduce(
    operation: (acc: S, T) -> S
): S

reduce함수는 fold함수랑 거의 같은데 사용 목적도 같다. reduce 함수에는 누적자이ㅡ 초깃값 인자가 없다는 것이 fold함수와 가장 큰 차이다.
따라서 누적자의 초기값은 컬렉션의 첫 번째 값으로 초기화된다
*/

// reduce 함수의 구현
public inline fun IntArray.reduce(
    operation: (acc: Int, Int) -> Int
): Int {
    if (isEmpty())
        throw UnsupportedOperationException(
            "Empty array can't be reduced"
        )
    var accumulator = this[0]
    for (index in 1..lastIndex) {
        accumulator = operation(accumulator, this[index])
    }
    return accumulator
}


// reduce를 이용한 합(sum) 구현

fun sumReduce(vararg nums: Int) =
    nums.reduce { acc, i -> acc + i }