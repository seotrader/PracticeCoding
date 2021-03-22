/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 */

fun main() {
    val wordBreak = WordBreak()
    val wordDict = arrayListOf<String>("leet", "code")
    val input = "leetcode"

    val result = wordBreak.wordBreak(input, wordDict)

    println("Result = $result")
}

data class Position(var start: String,var end: String)

class WordBreak {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        var dp = Array<Boolean>(s.length+1) { i -> false }

        dp[0] = true

        for (i in 1..s.length) {
            for (j in 0..i-1) {
                val subStr = s.substring(j, i)
                if (dp[j] && wordDict.contains(subStr)) {
                    println("changing to TRUE, dp[$i] = ${dp[i]}")
                    dp[i] = true
                    break
                }
            }
        }
        return dp[s.lastIndex+1]
    }
}