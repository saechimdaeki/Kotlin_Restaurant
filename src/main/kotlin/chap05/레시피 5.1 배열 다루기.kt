package chap05

/**
문제: 코틀린에서 배열을 생성하고 배열에 데이터를 추가하고 싶다
해법: arrayOf 함수를 이용해 배열을 만들고 Array 클래스에 들어 있는 속성과 메소드를 이용해 배열에 들어 있는
값을 다룬다


 */

/** 자바에서 배열 인스턴스화
String[] strings = new String[4];
strings[0] = "an";
strings[1] = "array";
strings[2] = "of";
strings[3] = "strings";

//또는 더 쉽게
strings = "an array of strings".split(" ");
 */


fun main() {
    // arrayOf 팩토리 메서드 사용하기
    val strings = arrayOf("this", "is", "an", "array", "of", "strings")


    //arrayOfNulls 팩토리 메서드를 사용해 널로만 채워진 배열을 생성할 수 있다
    val nullStringArray = arrayOfNulls<String>(5)

    // 0부터 4까지의 제곱을 담고 있는 문자열 배열 "0", "1","4","9","16"
    val squares = Array(5) { i -> (i * i).toString() }

    // 코틀린에는 오토박싱과 언박싱 비용을 방지할 수 있는 기본 타입을 나타내는 클래스가 있다
    // booleanArrayOf, byteArrayOf, shorAr, rayOf, charArrayOf, intArrayOf, longArrayOf,
    // floatArrayOf, doubleArrayOf 함수는 예상하는 것처럼 연관된 타입 배열을 생성한다
}


