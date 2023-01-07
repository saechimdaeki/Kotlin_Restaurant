package chap05

/**
문제 : 키 리스트가 있을 때 각각의 키와 생성한 값을 연관시켜서 맵을 만들고 싶다
해법 : associateWith 함수에 각 키에 대해 실행되는 람다를 제공해 사용한다
설명 : 한 묶음의 키가 있고 각 키를 생성된 값과 매핑하고 싶다고 하자. 그렇게 하는 방법 중 하나는
다음처럼 associate 함수를 사용하는 것이다

val keys = 'a' .. 'f'
val map = keys.associate { it to it.toString().repeat(5).capitalize()}
println(map)

이 코드의 실행 결과는 다음과 같다
{a=Aaaaa, b= Bbbbb, c =Ccccc d=Ddddd e=Eeeee}
 */

fun main(){
    // associateWith로 값 생성하기 해당 예제는 saechimdaeki가 deprecated된 기능을 최신화 시킴.
    val keys = 'a'..'f'
    val map = keys.associateWith { it.toString().repeat(5).replaceFirstChar(Char::titlecase) }
    println(map)
}