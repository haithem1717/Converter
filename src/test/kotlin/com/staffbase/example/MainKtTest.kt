package com.staffbase.example

import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.RepetitionInfo
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import parseIntToRoman
import parseAsRomanNumeral
import kotlin.streams.asStream
import kotlin.test.assertEquals

/*fun parseAsDecimal(n: Int) = n.toString()
fun String.parseAsRomanNumeral() = toInt()*/

internal class MainKtTest {
    @ParameterizedTest(name = "{index} => input(roman): {1} expected(decimal): {0} ")
    @CsvSource(
        "438, CDXXXVIII",
        "1828, MDCCCXXVIII",
        "3999, MMMCMXCIX"
    )
    fun `can convert to numbers`(decimal: Int, roman: String) {
        assertEquals(expected = decimal, actual = roman.parseAsRomanNumeral())
    }

    @ParameterizedTest(name = "{index} => input(decimal): {1} expected(roman): {0} ")
    @CsvSource(
        "438, CDXXXVIII",
        "1828, MDCCCXXVIII",
        "3999, MMMCMXCIX"
    )
    fun `can convert to roman numerals`(decimal: Int, roman: String) {
        assertEquals(expected = roman, actual = parseIntToRoman(decimal).asString)
    }

    companion object {
        @JvmStatic
        fun supportedNumberRange() = (1..3999).asSequence().asStream()
    }

    @ParameterizedTest(name = "conversion of number {0}")
    @MethodSource("supportedNumberRange")
    @ValueSource(ints = [1, 10, 1337, 65536])
    fun `forth and back should work`(number: Int) {
        assertEquals(expected = number, actual = parseIntToRoman(number).asString.parseAsRomanNumeral())
    }
}
