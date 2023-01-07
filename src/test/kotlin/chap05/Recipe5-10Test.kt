package chap05

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class `Recipe5-10Test` {



    @Test
    @DisplayName("Team 클래스의 Iterator 확장 함수 사용하기")
    fun testIterator(){
        val team = Team("Warriors")
        team.addPlayers(Player("Curry"),Player("Thompson"),Player("Durant"),
            Player("Green"),Player("Cousins"))

        assertEquals("Curry, Thompson, Durant, Green, Cousins",team.map { it.name }.joinToString())
    }
}