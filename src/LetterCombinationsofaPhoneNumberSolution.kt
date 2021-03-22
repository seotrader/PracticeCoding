/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]


Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].

 */

fun main() {
    val digits = "23"
    val letterCombinationsofaPhoneNumberSolution = LetterCombinationsofaPhoneNumberSolution()
    println("Result = ${letterCombinationsofaPhoneNumberSolution.letterCombinations(digits)}")
}


class LetterCombinationsofaPhoneNumberSolution {
    val result = arrayListOf<String>()
    var size=0
    private val mapLatters = hashMapOf<Char, Array<String>>(
            '2' to arrayOf("abc"),
            '3' to arrayOf("def"),
            '4' to arrayOf("ghi"),
            '5' to arrayOf("jkl"),
            '6' to arrayOf("mno"),
            '7' to arrayOf("pqrs"),
            '8' to arrayOf("tuv"),
            '9' to arrayOf("wxyz")
    )
    fun letterCombinations(digits: String): List<String> {
        size = digits.length
        if (digits.isEmpty()) return result
        backTrack(digits.length, digits[0], "", digits)
        return result
    }

    fun backTrack(n: Int, digit: Char, str: String, origin: String) {
        if (str.length == size) {
            result.add(str)
            return
        }
        val currentIndex = str.length
        val nextIndex = str.length+1
        println("Current Index = $currentIndex, nextIndex=$nextIndex")
        mapLatters[origin[currentIndex]]!!.forEach {
            it.forEach {currentElement->
                if (nextIndex < origin.length) {
                    mapLatters[origin[nextIndex]]!!.forEach {
                        it.forEach {nextElement->
                            backTrack(n, nextElement, str+currentElement+nextElement, origin)
                        }
                    }
                } else {
                    backTrack(n, currentElement, str+currentElement, origin)
                }

            }

        }
    }
}