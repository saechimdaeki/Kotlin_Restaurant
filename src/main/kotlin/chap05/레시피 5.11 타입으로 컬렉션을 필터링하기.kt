package chap05

import java.time.LocalDate

/**
 * 문제 : 여러 타입이 섞여 있는 컬렉션에서 특정 타입의 원소로만 구성된 새 컬렉션을 생성하고 싶다
 * 해법 : filterIsInstance 또는 filterIsInstanceTo 확장 함수를 사용한다
 */

fun main() {

    // 타입으로 컬렉션을 필터링 하기. 타입 이레이저(type erasure) 사용
    val list = listOf("a",LocalDate.now(), 3, 1, 4, "b")
    val strings = list.filter { it is String }

    for(s in strings){
//        s.length 컴파일되지 않음. 타입이 삭제됨
    }



}