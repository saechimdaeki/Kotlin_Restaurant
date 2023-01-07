package chap05

import java.time.LocalDate

/**
 * 문제 : 범위를 순회하고 싶지만 범위가 간단한 정수 (Integer, Long) 또는 문자로 구성되어 있지 않다
 * 해법 : 사용자 정의 수열을 생성한다
 */

// Comparable 타입을 위한 rangeTo 함수의 구현
//operator fun <T : Comparable<T>> T.rangeTo(that: T): ClosedRange<T> =
//    ComparableRange(this, that)

interface ClosedRange<T : Comparable<T>> {
    val start: T
    val endInclusive: T
    operator fun contains(value: T): Boolean =
        value >= start && value <= endInclusive

    fun isEmpty(): Boolean = start > endInclusive
}

class LocalDateProgression(
    override val start:LocalDate,
    override val endInclusive: LocalDate,
    val step: Long =1
) : Iterable<LocalDate>, chap05.ClosedRange<LocalDate> {
    override fun iterator(): Iterator<LocalDate>  =
        LocaldateProgressionIterator(start, endInclusive, step)

    infix fun step(days: Long) = LocalDateProgression(start, endInclusive, step)

    internal class LocaldateProgressionIterator(
        start: LocalDate,
        val endInclusive: LocalDate,
        val step: Long
    ) : Iterator<LocalDate> {

        private var current = start
        override fun hasNext() = current <= endInclusive

        override fun next(): LocalDate {
            val next = current
            current = current.plusDays(step)
            return next
        }

    }
}

