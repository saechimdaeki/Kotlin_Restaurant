package chap11

/**
 * 문제 : 난수를 생성하고 싶다
 * 해법 : Random 클래스에 있는 함수 중 하나를 사용한다
 *
 * 설명 : 기본적으로 kotlin.random.Random이 복잡하지는 않지만 구현은 꽤 모호하다.
 * Random 클래스에는 다음 메소드가 포함돼 있다
 */

// 추상 Random 클래스 내의 선언

/**
open fun nextInt(): Int

open fun nextInt(until: Int) : Int

open fun nextInt(from:Int, until: Int): Int

 */