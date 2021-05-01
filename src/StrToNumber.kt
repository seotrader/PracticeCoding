fun main() {
    var s = "765"
    println("Sum = ${strToNumber(s)}")
}

fun strToNumber(s: String): Int {
    var sum=0
    var multiply = 1
    var reverssed = s.reversed()
    s.forEach {
        sum+=(it.toInt()-48)*multiply
        sum *= 10
    }
    return sum/10
}
