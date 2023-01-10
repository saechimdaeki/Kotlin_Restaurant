package chap10

import java.io.Closeable
import java.io.File
import java.nio.charset.Charset

/**
 * 문제 : 파일 같은 리소스를 처리하고 사용을 끝마쳤을 때 확실하게 리소스를 닫고 싶지만
 * 코틀린은 자바의 try-with-resource 구문을 지원하지 않는다
 *
 * 해법 : kotlin.io 패키지의 use 또는 java.io.Reader의 useLines 확장 함수를 사용한다
 *
 */

/**
 * 코틀린은 try-with-resources 구조를 지원하지 않는다.
 * 대신 코틀린은 Closeable에는 확장함수 use, Reader와 File에는 useLine을 추가했다
 */

// 웹스터 사전에서 가장 긴단어 10개 찾기
fun get10LongestWordsInDictionary() {
    File("/usr/share/dict/words").useLines { line ->
        line.filter { it.length > 20 }
            .sortedByDescending(String::length)
            .take(10)
            .toList()
    }
}

// File.useLines 확장 함수의 구현

inline fun <T> File.useLines(
    charset: Charset = Charsets.UTF_8,
    block: (Sequence<String>) -> T
): T = bufferedReader(charset).use { block(it.lineSequence()) }

// 이 구현은 BufferedReader를 생성하고 BufferedReader의 use 함수에 처리를 위임한다

// Closeable에 들어 있는 use 확장 함수의 시그니처
/**
inline fun <T: Closeable?, R> T.use(block: (T) -> R): R
 */