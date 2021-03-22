/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]


Constraints:

1 <= n <= 8
 */

fun main() {
    val generateParentheses = GenerateParentheses()
    println("Result = ${generateParentheses.generateParenthesis(1)}")
}

class GenerateParentheses {

    val result = arrayListOf<String>()

    fun generateParenthesis(n: Int): List<String> {
        if (n<1) return result
        helper(n, "", 0, 0)
        return result

    }

    fun helper(n: Int,
               generated: String,
               countLeft: Int,
               countRight: Int) {
        if (generated.length==n*2) {
            if (countLeft==countRight) {
                result.add(generated)
            }
            return
        }
        helper(n, "$generated(", countLeft+1, countRight)

        if (countRight<countLeft) {
            helper(n, "$generated)", countLeft, countRight+1)
        }
    }

}