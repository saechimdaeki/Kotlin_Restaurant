package chap08

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class `Recipe8-5Test` {

    @Test
    @DisplayName("맵으로 Project 인스턴스 생성하기")
    fun useMapDelegateTest() {
        val project = Project(
            mutableMapOf(
                "name" to "Learn Kotlin",
                "priority" to 5,
                "completed" to true
            )
        )

        assertAll(
            { assertEquals("Learn Kotlin", project.name) },
            { assertEquals(5, project.priority) },
            { assertTrue(project.completed) }
        )
    }

    @Test
    @DisplayName("JSON 문자열로 Project 속성을 파싱")
    fun createProjectFromMapJSON(){
        val project = Project(getMapFromJSON())
        assertAll(
            { assertEquals("Learn Kotlin", project.name) },
            { assertEquals(5, project.priority) },
            { assertTrue(project.completed) }
        )
    }
}