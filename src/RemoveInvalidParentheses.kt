import java.lang.StringBuilder

/*
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]
Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
Example 3:

Input: ")("
Output: [""]


()())()

 */

fun main() {
    val removeInvalidParentheses = RemoveInvalidParentheses()

    val orig = "()("
    println("Orig = $orig")
    println("Result = ${removeInvalidParentheses.removeInvalidParentheses(orig)}")


}
class RemoveInvalidParentheses {

    val result = mutableSetOf<String>()
    var minRemoveCount = Int.MAX_VALUE

    fun removeInvalidParentheses(s: String): List<String> {
        result.clear()
        helper(s, 0, 0, 0, StringBuilder(), 0)
        return result.toList()
    }

    fun helper(s: String,
               index: Int,
               leftCount: Int,
               rightCount: Int,
               exp: StringBuilder,
               removeCount: Int) {
        // If we've reached the end of the string
        if (index == s.length) {
            if (removeCount <= minRemoveCount) {
                // we got a valid one
                if (leftCount == rightCount) {
                    if (removeCount < minRemoveCount) {
                        // We found a shorter valid one, so clear it
                        result.clear()
                        minRemoveCount = removeCount
                    }
                    result.add(exp.toString())
                }
            }
        } else {
            // get the current character
            val currentCharacter = s[index]
            val length = exp.length

            if (currentCharacter != '(' && currentCharacter != ')') {
                // Add it to the final solution
                exp.append(currentCharacter)
                // call helper for the current
                helper(s , index + 1, leftCount, rightCount, exp, removeCount)
                exp.deleteCharAt(length)
            } else {
                // delete the current char and try
                helper(s, index + 1, leftCount, rightCount, exp, removeCount + 1)
                exp.append(currentCharacter)
                if (currentCharacter == '(') {
                    helper(s, index + 1, leftCount + 1, rightCount, exp, removeCount)
                } else if (rightCount < leftCount) {
                    helper(s, index + 1, leftCount, rightCount + 1, exp, removeCount)
                }
                exp.deleteCharAt(length)
            }
        }
    }
}