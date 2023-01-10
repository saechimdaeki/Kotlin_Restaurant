package chap09

import org.junit.After
import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

class `Recipe9-1Junit4Test` {
    companion object {
        @JvmStatic
        private val strings = listOf("this","is","a","list","of","strings")

        @BeforeClass
        @JvmStatic
        fun runBefore(){
            println("BeforeClass : $strings")
        }

        @AfterClass
        @JvmStatic
        fun runAfter() {
            println("AfterClass : $strings")
        }
    }

    private val modifiable = ArrayList<Int>()

    @Before
    fun initialize(){
        println("Before: $modifiable")
        modifiable.add(3)
        modifiable.add(1)
        modifiable.add(4)
        modifiable.add(1)
        modifiable.add(5)
    }

    @Test
    fun test1(){
        //..
    }

    @After
    fun finish(){
        println("After : $modifiable")
    }
}
