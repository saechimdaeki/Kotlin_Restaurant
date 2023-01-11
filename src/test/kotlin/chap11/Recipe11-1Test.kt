package chap11

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class `Recipe11-1Test` {

    @Test
    @DisplayName("코틀린 버전 비교하기")
    fun testKotlinVersion() {
        val v12 = KotlinVersion(major = 1, minor = 2)
        val v1341 = KotlinVersion(1, 3, 41)
        assertAll(
            { assertTrue(v12 < KotlinVersion.CURRENT) },
            { assertTrue(v1341 <= KotlinVersion.CURRENT) },
            { assertEquals(KotlinVersion(1, 3, 41), KotlinVersion(major = 1, minor = 3, patch = 41)) }
        )
    }

    @Test
    @DisplayName("주어진 값보다 상위 버전인지 확인하기")
    fun currentVersion(){
        assertTrue(KotlinVersion.CURRENT.isAtLeast(major = 1, minor = 3))
        assertTrue(KotlinVersion.CURRENT.isAtLeast(major = 1, minor = 3, patch = 40))
    }
}