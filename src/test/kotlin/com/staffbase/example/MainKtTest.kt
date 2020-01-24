package com.staffbase.example

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import parseAsRomanNumeral

internal class MainKtTest {
    @ParameterizedTest(name = "{index} => input(roman): {1} expected(decimal): {0} ")
    @CsvSource(
        "438, CDXXXVIII",
        "1828, MDCCCXXVIII",
        "3999, MMMCMXCIX"
    )
    fun `can convert to numbers`(decimal: Int, roman: String){
        assertEquals(decimal, roman.parseAsRomanNumeral())
    }
}
