package chap09

import java.time.LocalDate

/**
 * 문제 : 코드를 부풀리지 않고 객체의 여러 속성을 체크하고 싶다.
 * 해법 : 원하는 모든 속성을 캡슐화하는 데이터 클래스를 생성한다
 *
 * 설명 : 코틀린의 데이터 클래스는 equals, toString, hashCode, copy와 구조 분해를 위한 component 메소드가
 * 자동으로 포함된다. 데이터 클래스의 이런 특성은 테스르를 위한 래핑하기에 적합하다.
 *
 * @See Recipe9-2Test
 */

data class Book(
    val isbn:String,
    val title: String,
    val author: String,
    val published: LocalDate
)