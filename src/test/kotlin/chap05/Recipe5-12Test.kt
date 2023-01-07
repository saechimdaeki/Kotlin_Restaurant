package chap05

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import java.time.LocalDate
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class `Recipe5-12Test` {

    @Test
    @DisplayName("범위 안에서 LocalDate 사용하기")
    fun localdate() {
        val startDate = LocalDate.now()
        val midDate = startDate.plusDays(3)
        val endDate = startDate.plusDays(5)

        val dateRange = startDate..endDate

        assertAll(
            { assertTrue(startDate in dateRange) },
            { assertTrue(midDate in dateRange) },
            { assertTrue(endDate in dateRange) },
            { assertTrue(startDate.minusDays(1) !in dateRange) },
            { assertTrue(endDate.plusDays(1) !in dateRange) }
        )

        /**
         *  이 코드는 다 동작하지만 이 범위를 순회하면 놀라운 일이 일어난다
         *  for(date in dateRange) println(it) // 컴파일 에러
         *  (startDate..endDate).forEach{/*..*/} // 컴파일 에러
         *  문제는 범위가 수열이 아니라는 점. 수열은 순서 있는 값의 연속이다. 사용자 정의 수열은
         *  코틀린 표준 라이브러리의 IntProgression, LongProgression, CharProgression처럼 Iterable인터페이스를 구현해야한다
         */
    }

    @Test
    @DisplayName("LocalDate 수열의 테스트")
    fun useLocalDateProgression() {
        val startDate = LocalDate.now()
        val endDate = startDate.plusDays(5)

        val dateRange = startDate..endDate

        dateRange.forEachIndexed { index, localDate ->
            assertEquals(localDate, startDate.plusDays(index.toLong()))
        }

        val dateList = dateRange.map { it.toString() }
        assertEquals(6, dateList.size)
    }

    @Test
    fun useLocaDateProgressionWithStep(){
        val startDate = LocalDate.now()
        val endDate = startDate.plusDays(5)

        val dateRange = startDate..endDate step 2


        val dateList = dateRange.map { it.toString() }
        assertEquals(6, dateList.size)
    }

    operator fun LocalDate.rangeTo(other: LocalDate) = LocalDateProgression(this, other)
}