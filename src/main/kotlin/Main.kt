import Character.*

enum class Character() {
    I, V, X, L, C, D, M
}

fun romanToNumber(number: String): Int {
    var sum = 0
    var currentCharValue = 0
    var previousCharValue = 0
    for (char in number.reversed()) {
        if (char.toString() == I.toString())
            currentCharValue = 1
        else if (char.toString() == V.toString())
            currentCharValue =5
        else if (char.toString() == X.toString())
            currentCharValue = 10
        else if (char.toString() == L.toString())
            currentCharValue = 50
        else if (char.toString() == C.toString())
            currentCharValue = 100
        else if (char.toString() == D.toString())
            currentCharValue = 500
        else if (char.toString() == M.toString())
            currentCharValue = 1000

        if(currentCharValue >= previousCharValue)
            sum += currentCharValue
        else
            sum -= currentCharValue
        previousCharValue = currentCharValue
    }
    return sum
}

fun main() {
}