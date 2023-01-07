package chap05

/**
문제 : 컬렉션을 처리할 때 컬렉션의 모든 원소가 선택에서 제외되지만 기본 응답을 리턴하고 싶다
해법 : 컬렉션이나 문자열이 비어 있는 경우에는 ifEmpty와 ifBlank 함수를 사용해 기본값을 리턴한다
 */

data class Product(
    val name: String,
    var price: Double,
    var onSale: Boolean = false
)

//상품 리스트가 있는데 그 리스트에서 판매중인 상품의 이름을 얻으려고 한다면 , 다음처럼 간단한 필터연산을 하면된다
fun namesOfProductsOnSale(products: List<Product>) =
    products.filter { it.onSale }
        .map { it.name }
        .joinToString(separator = ", ")

//위 코드의 문제는 판매 중인 상품이 없는 경우 filter는 빈 컬렉션을 리턴하고 그런 다음 빈 문자열로 변환된다는 점이다
// 실행 결과가 비었을 경우 특정 문자열을 리턴하려면 ifEmpty라는 이름의 컬렉션과 문자열 모두에 사용한다
fun onSaleProducts_ifEmptyCollection(products: List<Product>) =
    products.filter { it.onSale }
        .map { it.name }
        .ifEmpty { listOf("none") }
        .joinToString(separator = ", ")

fun onSaleProducts_ifEmptyString(products: List<Product>) =
    products.filter { it.onSale }
        .map { it.name }
        .joinToString(separator = ", ")
        .ifEmpty { "none" }

