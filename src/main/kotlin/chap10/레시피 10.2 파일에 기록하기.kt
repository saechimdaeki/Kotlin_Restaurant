package chap10

import java.io.File

/**
 * 문제 : 파일에 기록을 하고 싶다
 * 해법 : File 클래스의 확장 함수에는 일반적인 자바 입출력 메소드뿐만 아니라 출력 스트림과 라이터(Writer)를
 * 리턴하는 확장 함수가 있다
 */

// 파일의 모든 텍스트 치환하기

fun main() {
    File("myfile.txt").writeText("My data")
}

// use 함수로 파일 작성하기
/**
 * File(fileName).printWriter().use{
 *  writer -> writer.println(data)
 * }
 */
