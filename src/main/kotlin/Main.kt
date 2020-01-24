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

fun main() {
    sequenceOf(
        "CMXXVIII", "DCCCXXXV", "MMDCLXXXII", "CVIII", "MMMCMXCIX",
        "MDCCCXXVIII", "CDXXXVIII"
    ).map(String::parseAsRomanNumeral).forEach(::println)
}