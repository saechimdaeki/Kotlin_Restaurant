package chap05

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals

class `Recipe5-4Test` {

    private val over = Product("over", 1_000_000.0)
    private val saechim = Product("saechim", 299_999.95, onSale = true)
    private val tps = Product("tps", 0.25)

    @Test
    fun productOnSale() {
        val products = listOf(over, saechim, tps)
        assertAll(
            "On sale products",
            { assertEquals("saechim", onSaleProducts_ifEmptyCollection(products)) },
            { assertEquals("saechim", onSaleProducts_ifEmptyString(products)) }
        )
    }

    @Test
    fun productsNotOnSale() {
        val products = listOf(over, tps)
        assertAll("No products on sale",
            { assertEquals("none", onSaleProducts_ifEmptyCollection(products)) },
            { assertEquals("none", onSaleProducts_ifEmptyString(products)) }
        )
    }


}