package chap09

import java.time.LocalDate

/**
 * 문제 : 테스트 객체를 빠르게 생성하고 싶다.
 * 해법 : copy 함수를 사용하거나 필요하지도 않은 생성자 기본 인자를 명시하지 말고 기본 인자를 가진 도움 함수를 제공한다
 */

// 각 인자에 기본값을 제공하도록 Book 클래스를 수정하지말고 기본값을 생성하는 팩토리 함수를 추가하자

fun createBook(
    isbn: String = "123456",
    title: String = "kotlin cookBook",
    author: String = "saechimdaeki",
    published: LocalDate = LocalDate.parse("2023-01-09")
) = Book(isbn, title, author, published)


// 팩토리 함수로 Book todtjdgkrl

val kotlinCookBookRecipe = createBook()

val makingKotlinGroovy = createBook(
    isbn = "12312312414",
    title = "making kotlin groovy",
    published = LocalDate.parse("2022-12-25")
)

/**
 * 기본 인자는 오직 테스트 데이터를 생성하기 위해 사용됐기 때문에 도메인 클래스 자체에 기본 인자를 추가할 필요가 없다. 이론상 똑같은
 * 일을 하기 위해 data클래스에서 제공되는 copy함수를 사용할 수 있지만 copy함수를 광범위하게 사용하면 특히 중첩구조에서
 * 가독성이 떨어진다
 *
 */

data class MultiAuthorBook(
    val isbn: String,
    val title: String,
    val authors: List<String>,
    val published: LocalDate
)

fun createMultiAuthorBook(
    isbn: String = "13122414",
    title: String = "Kotlin in Action",
    authors: List<String> = listOf("saechimdaeki", "kimjunseong"),
    published: LocalDate = LocalDate.parse("2000-04-13")
) = MultiAuthorBook(isbn, title, authors, published)