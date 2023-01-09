package chap08

import kotlin.reflect.KProperty

/**
 * 문제 : 어떤 클래스의 속성이 다른 클래스의 획득자와 설정자를 사용하게끔 만들고 싶다
 * 해법 : ReadOnlyProperty 또는 ReadWriteProperty를 구현하는 클래스를 생성함으로써 직접 속성 대리자를 작성한다
 * 설명 : 대체로 클래스의 속성은 지원 필드와 함께 동작하지만 필수는 아니다. 대신 값을 획득하거나 설정하는 동작을 다른 객체에 위임할 수 있다.
 * 사용자 정의 속성 대리자를 생성하려면 ReadOnlyProperty 또는 ReadWriteProperty 인터페이스에 존재하는 함수를 제공해야한다
 */

// ReadOnlyProperty와 ReadWriteProperty의 인터페이스
interface ReadOnlyProperty<in R, out T> {
    operator fun getValue(thisRef: R, property: KProperty<*>): T
}

interface ReadWriteProperty<in R, T> {
    operator fun getValue(thisRef: R, property: KProperty<*>): T
    operator fun setValue(thisRef: R, property: KProperty<*>, value: T)
}

// 코틀린 표준 문서의 Delegate(예제) 클래스
class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me "
    }
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef")
    }
}

//방금 작성한 대리자를 사용하려면 아래처럼 위임할 클래스 또는 변수를 생성한 다음 해당 변수를 가져오거나 설정해야한다
class Example{
    var p: String by Delegate()
}

fun main() {
    val e = Example()
    println(e.p)
    e.p = "NEW"
}


/**
 * 코틀린 표준 라이브러리에는 닥수의 대리자가 들어있다. 완전히 다른 예제 집합으로서 그레이들 빌드 도구는 위임된 속성을 통해 컨테이너와 상호작용 할 수 있게
 * 도와주는 코틀린 DSL을 제공한다. 그레이들에는 두 개의 주요 속성 영역이 있다. 그 중 하나는 프로젝트 자체(org.gradle.api.Project)와 연관된
 * 속성의 집합이고, 다른 하나는 프로젝트 전체에서 사용할 수 있는 extra 속성이다
 * @see build.gradle.kts
 *
 * -PmyProperty=value 문법을 사용해 명령줄에서 프로젝트 속성을 설정하거나 gradle.properties 파일에서 프로젝트 속성을 설정할 수 있다.
 * extra 속성은 인자를 사용하거나 처음 접근 시에 평가되는 람다를 사용해 정의할 수 있다.
 */


