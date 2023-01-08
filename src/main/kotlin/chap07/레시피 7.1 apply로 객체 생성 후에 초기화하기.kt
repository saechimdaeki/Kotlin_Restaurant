package chap07

/**
 * 문제 : 객체를 사용하기 전에 생성자 인자만으로는 할 수 없는 초기화 작업이 필요하다
 * 해법 : apply 함수를 사용한다
 * 설명 : 코틀린에는 객체에 적용할 수 있는 몇몇의 영역함수가 있다. apply 함수는 this를 인자로 전달하고
 * this를 리턴하는 확장함수다
 *
 * apply 함수의 정의
 * inline fun <T> T.apply(block: T.() -> Unit): T
 */


/*
class JdbcOfficerDAO(private val jdbcTemplate: JdbcTemplate) {
    private val insertOfficer = SimpleJdbcInsert(jdbcTemplate)
        .withTableName("OFFICERS")
        .usingGeneratedKeyColumns("id")

    fun save(officer: Officer) =
        officer.apply {
            id = insertOfficer.executeAndReturnKey(
                mapOf(
                    "rank" to rank,
                    "first_name" to first,
                    "last_name" to last
                )
            )
        }
}
*/
