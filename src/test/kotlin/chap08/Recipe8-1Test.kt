package chap08

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class `Recipe8-1Test` {

    private val smartPhone: SmartPhone = SmartPhone()

    @Test
    @DisplayName("SmartPhone 클래스 테스트_internal_phone")
    fun internalPhoneTest() {
        assertEquals("Dialing 555-1234...", smartPhone.dial("555-1234"))
    }

    @Test
    @DisplayName("SmaprtPhone 클래스 테스트_internal_camera")
    fun internalCameraTest() {
        assertEquals("Taking picture...", smartPhone.takePicture())
    }
}