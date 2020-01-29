package com.staffbase.example

import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import parseIntToRoman
import parseAsRomanNumeral
import kotlin.test.assertEquals

fun parseAsDecimal(n: Int) = n.toString()
fun String.parseAsRomanNumeral() = toInt()

internal class MainKtTest {
    @ParameterizedTest(name = "{index} => input(roman): {1} expected(decimal): {0} ")
    @CsvSource(
        "438, CDXXXVIII",
        "1828, MDCCCXXVIII",
        "3999, MMMCMXCIX"
    )
    fun `can convert to numbers`(decimal: Int, roman: String){
        assertEquals(expected = decimal, actual = roman.parseAsRomanNumeral())
    }

    @ParameterizedTest( name = "{index} => input(decimal): {1} expected(roman): {0} ")
    @CsvSource( "MMMCM, 3900")
    fun `can convert to roman numerals`(roman : String, decimal: Int){
        assertEquals(expected = roman, actual = parseIntToRoman(decimal))
    }

    @RepeatedTest(3998)
    fun `forth and back should work`(index: Int) {
        val number = index + 1
        assertEquals(expected = number, actual = parseIntToRoman(number).parseAsRomanNumeral())
    }
}
