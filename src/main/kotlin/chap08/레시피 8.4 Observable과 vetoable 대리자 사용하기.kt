package chap08

import kotlin.properties.Delegates
import kotlin.properties.ObservableProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * 문제 : 속성의 변경을 가로채서, 필요에 따라 변경을 거부하고 싶다
 * 해법 : 변경 감지에는 observable 함수를 사용하고, 변경의 적용 여부를 결정할 때는 vetoable 함수와 람다를 사용하자
 *
 * 문제 : 코틀린 표준 라이브러리에서 Delegates 객체의 observable 함수와 vetoable함수는 사용하기 쉽다
 * 하지만 observable 함수와 vetoable 함수의 구현은 개발자가 대리자를 작성할 때 참고할만한 좋은 패턴이다
 *
 */

// observable과 vetoable 함수의 시그니처
/*

fun <T> observable(
    initialValue: T, onChange: (property: KProperty<*>, oldValue: T, newValue: T) -> Unit
): ReadWriteProperty<Any?, T>

fun <T> vetoable(
    initialValue: T, onChange: (property: KProperty<*>, oldValue: T, newValue: T) -> Boolean
): ReadWriteProperty<Any?, T>
*/


// observable과 vetoable 함수의 사용법

var watched: Int by Delegates.observable(1) { prop, old, new ->
    println("${prop.name} changed from $old to $new")
}

var checked: Int by Delegates.vetoable(0) { prop, old, new ->
    println("Trying to change ${prop.name} from $old to $new")
    new >= 0
}


// observable과 vetoable 함수 사용법은 매우쉽다.
// Delegates 내의 팩토리 함수
object Delegates {
    // .. 다른 구현들 ..
    inline fun <T> observable(
        initialValue: T,
        crossinline onChange: (property: KProperty<*>, oldValue: T, newValue: T) -> Unit
    ): ReadWriteProperty<Any?, T> =
        object : ObservableProperty<T>(initialValue) {
            override fun afterChange(property: KProperty<*>, oldValue: T, newValue: T) =
                onChange(property, oldValue, newValue)
        }

    inline fun <T> vetoable(
        initialValue: T,
        crossinline onChange: (property: KProperty<*>, oldValue: T, newValue: T) -> Boolean
    ): ReadWriteProperty<Any?, T> =
        object : ObservableProperty<T>(initialValue) {
            override fun beforeChange(property: KProperty<*>, oldValue: T, newValue: T): Boolean =
                onChange(property, oldValue, newValue)
        }
}

// 대리자를 제공하기 위해 사용되는 ObservableProperty 클래스
abstract class ObservableProperty<T>(initialValue: T) : ReadWriteProperty<Any?, T> {
    private var value = initialValue

    protected open fun beforeChange(property: KProperty<*>, oldValue: T, newValue: T): Boolean = true

    protected open fun afterChange(property: KProperty<*>, oldValue: T, newValue: T): Unit {}

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        val oldValue = this.value
        if (!beforeChange(property, oldValue, value)) {
            return
        }

        this.value = value
        afterChange(property, oldValue, value)
    }
}