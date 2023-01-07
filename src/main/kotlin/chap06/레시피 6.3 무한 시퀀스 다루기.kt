package chap06

/**
 * 문제 : 무한대의 원솔르 갖는 시퀀스의 일부분이 필요하다
 * 해법 : 널을 리턴하는 시퀀스 생성기를 사용하거나 시퀀스 확장 함수 중에서 takwWhile 같은 함수를 사용하자
 * 설명 :
 * 자바의 스트림과 비슷한 시퀀스에는 중간 연산과 최종 연산이 있다. 중간 연산은 새로운 시퀀스를 리턴하고
 * 최종 연산은 시퀀스가 아닌 어떤 것이든 리턴할 수 잇다. 시퀀스에서 함수 호출로 연결된 파이프라인을 생성할 때
 * 최종 연산이 수행될 때까지 어떤 데이터도 시퀀스의 파이프라인을 통과하지 않는다
 */

// 처음 n개의 소수 찾기
fun firstNPrimes(count: Int) =
    generateSequence(2, ::nextPrime) // 2부터 시작하는 무한 시퀀스
        .take(count) // 요청한 수만큼만 원소를 가져오는 중간 연산
        .toList() // 최종 연산

// 주어진 수보다 작은 모든 소수 (버전 1)
fun primesLessThan(max: Int): List<Int> =
    generateSequence(2) { n -> if (n < max) nextPrime(n) else null }
        .toList()
        .dropLast(1)

// 주어진 수보다 작은 모든 소수 (버전 2)
fun primesLessThan2(max: Int): List<Int> =
    generateSequence(2, ::nextPrime)
        .takeWhile { it < max }
        .toList()