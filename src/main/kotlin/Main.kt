enum class Digit(val value: Int) {
    I(1), V(5), X(10), L(50), C(100), D(500), M(1000);

    companion object {
        private val MAPPING = values().associate { digit -> digit.name[0] to digit.value }

        fun valueFor(c: Char): Int? = MAPPING[c]
    }
}

infix fun Int.isLessThan(that: Int): Boolean = this < that

private data class Accumulator(val value: Int = 0, val previousCharValue: Int = 0)

fun String.parseAsRomanNumeral(): Int {
    return reversed().asSequence()
        .fold(initial = Accumulator()) { (value, previousCharValue), currentChar ->
            val currentCharValue = Digit.valueFor(currentChar) ?: throw IllegalStateException()
            return@fold Accumulator(
                value = when {
                    currentCharValue >= previousCharValue -> value + currentCharValue
                    else -> value - currentCharValue
                },
                previousCharValue = currentCharValue
            )
        }
        .value
}

enum class Character(val value: Int) {
    I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50),
    XC(90), C(100), CD(400), D(500), CM(900), M(1000)
}

data class Roman(var asString: String, var asInteger: Int)

fun parseIntToRoman(number: Int): Roman {
    val numeral = Roman("", 0)
    val listOfCategories = listOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1).filter { it <= number }
    listOfCategories.forEach { category ->
        while (numeral.asInteger <= number - category)
            numeral.apply {
                numeral.asInteger += category
                numeral.asString += Character.values().firstOrNull { it.value == category }!!
            }
    }
    return numeral
}

fun main() {
    /*sequenceOf(
        "CMXXVIII", "DCCCXXXV", "MMDCLXXXII", "CVIII", "MMMCMXCIX",
        "MDCCCXXVIII", "CDXXXVIII"
    ).map(String::parseAsRomanNumeral).forEach(::println)*/
    println(parseIntToRoman(1234).asString)
}