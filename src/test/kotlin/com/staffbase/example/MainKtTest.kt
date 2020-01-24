package com.staffbase.example

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import romanToNumber

internal class MainKtTest {
    @Test
    fun `can convert to numbers`(){
        val number1 = "CDXXXVIII"
        val number2 = "MDCCCXXVIII"
        val number3 = "MMMCMXCIX"
        assertEquals(438,romanToNumber(number1))
        assertEquals(1828,romanToNumber(number2))
        assertEquals(3999,romanToNumber(number3))

    }

    @Test
    private fun convertToNumbers() {


    }
}
