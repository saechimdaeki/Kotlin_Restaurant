package chap09

/**
 * 문제 : 파라미터화된 테스트를 좀 더 쉽게 읽는 테스트 결과를 생성하고 싶다
 * 해법 : 입력 값과 예상 값을 감싸는 data 클래스를 만들고, 만든 data 클래스 기반의 테스트 데이터를 생성하는 함수를
 * 테스트 메서드 소스로서 사용한다
 */

// 입력과 예상 결과를 담는 데이터 클래스
data class FibonacciTestData(val number:Int, val expected: Int)