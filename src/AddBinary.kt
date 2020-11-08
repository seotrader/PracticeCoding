fun main() {
    var a = "111010"
    var b = "1011"

    println("$a +")
    println("$b")

    println("addBinary = ${addBinary(a, b)}")
}

data class Result (var s: Char = '\u0000', var reminder: Int=0 )

fun calculate(a: Char, b: Char, reminder: Int): Result {
    if (reminder==1) {
        when {
            a=='1' && b=='1' -> return Result('1',1)
            a=='1' && b=='0' -> return Result('0', 1)
            a=='0' && b=='1' -> return Result('0', 1)
            a=='0' && b=='0' -> return Result('1', 0)
        }
    }
    if (reminder==0) {
        when {
            a == '1' && b == '1' -> return Result('0', 1)
            a == '1' && b == '0' -> return Result('1', 0)
            a == '0' && b == '1' -> return Result('1', 0)
            a == '0' && b == '0' -> return Result('0', 0)
        }
    }
    return Result('0',0)
}

fun addBinary(a: String, b: String): String {
    var result = ""

    var revA = a.reversed()
    var revB = b.reversed()

    var lenA = revA.length
    var lenB = revB.length

    var short = if (lenA<lenB) lenA else lenB
    val isAShorter = (lenA<lenB)

    var reminder = 0
    for (i in 0 until short) {
        var newChar =  calculate(revA[i], revB[i], reminder)
        println("original reminder = $reminder, new char = ${newChar.s}, reminder = ${newChar.reminder}")
        result = newChar.s+result
        reminder = newChar.reminder
    }

    println("First step=$result")

    var leftOver = if (isAShorter) lenB-lenA else lenA-lenB
    var lastIndex = if (isAShorter) lenB else lenA
    var startIndex = if (isAShorter) lenA else lenB

    if (lenA==lenB && reminder==1) {
        result = "1$result"
        return result
    }

    println("start index=$startIndex, leftOver = $leftOver, lastIndex = $lastIndex")
    for (i in startIndex until lastIndex) {
        if (isAShorter) {
            var newChar =  calculate('0', revB[i], reminder)
            result = newChar.s+result
            reminder = newChar.reminder
        } else {
            var newChar = calculate(revA[i], '0', reminder)
            result = newChar.s + result
            reminder = newChar.reminder
        }
    }

    if (reminder==1) result = "1$result"

    return result

}
