package chap11

import com.google.gson.Gson
import java.net.URL

/**
 * 문제 : 클래스에서 단일 함수를 간단하게 호출하고 싶다
 * 해법 : 함수를 호출할 클래스에서 invoke 연산자 함수를 재정의한다
 */

/**
 * 오픈 노티파이 서비스가 리턴하는 JSON 데이터는 다음과 같다
 * {
 *  "peple": [
 *      {"name": "Oleg Konnenko","craft": "ISS"} ,
 *      {"name": "David", "craft": "ISS" }
 *  ],
 *  "number": 3,
 *  "message": "success"
 * }
 */

data class AstroResult(
    val message: String,
    val number: Number,
    val people: List<Assignment>
)

data class Assignment(
    val craft: String,
    val name: String
)

// 오픈 노티파이 서비스에 접근해 결과 파싱하기

class AstroRequest {
    companion object {
        private const val ASTRO_URL =
            "http://api.open-notify.org/astros.json"
    }

    operator fun invoke(): AstroResult {
        val responseString = URL(ASTRO_URL).readText()
        return Gson().fromJson(
            responseString,
            AstroResult::class.java
        )
    }
}