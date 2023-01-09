package chap08

import com.google.gson.Gson

/**
 * 문제 : 여러 값이 들어 있는 맵을 제공해 객체를 초기화하고 싶다
 * 해법 : 코틀린 맵에는 대리자가 되는 데 필요한 getValue와 setValue 함수 구현이 있다
 * 설명 : 객체 초기화에 필요한 값이 맵 안에 있다면 해당 클래스 속성을 자동으로 맵에 위임할 수 있다.
 */

data class Project(val map: MutableMap<String, Any?>) {
    val name: String by map
    var priority: Int by map
    var completed: Boolean by map
}

// JSON 문자열로 Project 속성을 파싱

fun getMapFromJSON() =
    Gson().fromJson<MutableMap<String, Any?>>(
        """{ "name":"Learn Kotlin", "priority":5, 
                "completed":true }""",
        MutableMap::class.java
    )