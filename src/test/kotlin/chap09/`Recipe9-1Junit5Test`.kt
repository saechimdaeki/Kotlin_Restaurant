package chap09

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class `Recipe9-1Junit5Test` {

    private val strings = listOf("this","is","a","list","of","strings")

    private lateinit var modifiable : MutableList<Int>

    @BeforeEach
    fun setUp() {
        modifiable = mutableListOf(3,1,4,1,5)
        println("Before: $modifiable")
    }

    @AfterEach
    fun finish() {
        println("After: $modifiable")
    }

    @Test
    fun test1(){

    }
}