fun main() {
    val testCalls = TestCalls()
    testCalls.test1()
}

class TestCalls {
    fun test1() {
        var x = 5

        if (x==5 || test2()) {
            println("Yes")
        }
    }

    private fun test2(): Boolean {
        println("This is test2")
        return true
    }
}