package chap11

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class `Recipe11-5Test` {

    @Test
    @DisplayName("정수를 바이너리 문자열로 변환하기")
    fun toBinaryString() {
        val str = 42.toString(radix = 2)
        assertEquals(str, "101010")

        val num = "101010".toInt(radix = 2)
        assertEquals(num, 42)
    }


    @Test
    @DisplayName("바이너리 문자열 패딩")
    fun paddedBinaryString() {
        val strings = (0..15).map {
            it.toString(2).padStart(4, '0')
        }

        Assertions.assertThat(strings).contains(
            "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011",
            "1100", "1101", "1110", "1111"
        )

        val nums = strings.map { it.toInt(2) }
        Assertions.assertThat(nums).contains(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
    }
}