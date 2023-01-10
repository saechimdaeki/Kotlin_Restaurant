package chap09

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import java.time.LocalDate

class `Recipe9-2Test` {

    // Book 데이터 클래스의 모든 속성을 수동으로 테스트할 수 있다

    fun findBookByIsbn(isbn: String): Book {
        return Book(isbn = isbn, title = "saechimBook", author = "saechimdaeki", published = LocalDate.of(2000, 12, 31))
    }

    @Test
    @DisplayName("book의 모든 속성을 수동으로 테스트")
    fun testBookTheHardWay() {
        val book = findBookByIsbn("12345")
        assertThat(book.isbn).isEqualTo("12345")
        assertThat(book.title).isEqualTo("saechimBook")
        assertThat(book.author).isEqualTo("saechimdaeki")
        assertThat(book.published).isEqualTo(LocalDate.of(2000, 12, 31))
    }

    @Test
    @DisplayName("junit5의 assertAll을 이용해 모든 속성을 테스트하기 ")
    fun testBookTheAssertAll() {
        val book = findBookByIsbn("12345")
        assertAll(
            { assertThat(book.isbn).isEqualTo("12345") },
            { assertThat(book.title).isEqualTo("saechimBook") },
            { assertThat(book.author).isEqualTo("saechimdaeki") },
            { assertThat(book.published).isEqualTo(LocalDate.of(2000, 12, 31)) }
        )
    }

    @Test
    @DisplayName("테스트에 Book 데이터 클래스 사용하기")
    fun testBookUsingDataClass(){
        val book = findBookByIsbn("123")
        val expedcted = Book(isbn = "123"
        , title = "saechimBook", author = "saechimdaeki", published = LocalDate.of(2000,12,31))

        assertThat(book).isEqualTo(expedcted)
    }
}