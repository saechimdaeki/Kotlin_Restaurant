package chap08

/**
 * 문제 : 어떤 속성이 필요할 때까지 해당 속성의 초기화를 지연시키고 싶다.
 * 해법: 코틀린 표준 라이브러리의 lazy 대리자를 사용하자
 *
 * lazy 대리자를 사용하려면 다음과 같이 처음 접근이 일어날 때 값을 계산하기 위해 만들어진 () -> T 형식의 초기화 람다를 제공해야한다
 *  fun <T> lazy(initializer: () -> T ) : Lazy<T>
 *
 *  fun <T> lazy(
 *      mode: LazyThreadSafetyMode, initializer () -> T
 *  ): Lazy<T>
 *
 *  fun <T> lazy(lock: Anmy?, initializer: () -> T) : Lazy<T>
 */


// 처음 접근하게 될 때까지 속성의 초기화를 기다림
val ultimateAnswer: Int by lazy {
    println("computing the answer")
    42
}

/**
 * 첫 ultimateAnswer 호출은 lazy가 받은 람다를 실행하고 그다음 변수에 저장될 42를 리턴한다
 * 내부적으로 코틀린은 이 값을 캐시하는 Lazy 타입의 ultimateAnswer$delegate라는 특별한 속성을 생성한다
 * LazyThreadSafetyMode 타입의 인자는 다음과 같은 이넘을 받는다
 *
 * - SYNCHRONIZED : 오직 하나의 스레드만 Lazy 인스턴스를 초기화할 수 있게 락을 사용
 * - PUBLICATION : 초기화 함수가 여러 번 호출될 수 있지만 첫 번째 리턴값만 사용됨
 * - NONE : 락이 사용되지 않음
 *
 */