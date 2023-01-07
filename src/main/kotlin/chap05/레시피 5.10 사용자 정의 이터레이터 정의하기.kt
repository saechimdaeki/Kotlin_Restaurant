package chap05

/**
 * 문제 : 컬렉션을 감싼 클래스를 손쉽게 순회하고 싶다
 * 해법 : next와 hasNext 함수를 모두 구현한 이터레이터를 리턴하는 연산자 함수를 정의한다
 *
 */

data class Player(val name: String)

class Team(val name: String, val players: MutableList<Player> = mutableListOf()) : Iterable<Player> {
    fun addPlayers(vararg people: Player) =
        players.addAll(people)

    override fun iterator() : Iterator<Player> =
            players.iterator()
}

fun main() {
    // 팀에 속한 선수 순회하기
    val team = Team("Warriors")
    team.addPlayers(Player("Curry"),Player("Thompson"),Player("Durant"),
    Player("Green"),Player("Cousins"))

    for(player in team.players){
        println(player)
    }

    //직접적으로 팀을 순회하기
    operator fun Team.iterator() : Iterator<Player> = players.iterator()
    for(player in team){
        println(player)
    }
}