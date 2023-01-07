package chap05

/**
문제 : 변경 가능한 리스트, 세트, 맵이 있을때 해당 컬렉션의 읽기 전용 버전을 생성하고 싶다
해법 : toList, toSet, toMap 메서드를 사용해 새로운 읽기 전용 컬렉션을 생성하자.
기존 컬렉션을 바탕으로 읽기 전용 뷰를 만들려면 List,Set 또는 Map 타입의 변수에 기존 컬렉션을 할당

설명: mutableList 팩토리 메서드로 생성한 가변리스트는 add, remove등과 같은 메서드가 있다
 */
fun main() {
    val mutableNums = mutableListOf(3, 1, 4, 1, 5, 9)

    //변경 가능한 리스트의 읽기 전용 버전을 생성하는 방법은 두가지다. 첫번재 방법은
    // 다음처럼 toList 메서드를 호출하는 것이다

    val readonlyNumList = mutableNums.toList()
    println(mutableNums == readonlyNumList)
}