import java.lang.Math.abs

/*
Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"


Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case),
*/

fun main() {
    var str = "ibvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotliyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdyvnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusgjwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwruobfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy"
    println(str)
    var longestPalindromicSubString = LongestPalindromicSubString()

    var result = longestPalindromicSubString.longestPalindrome(str)

    println("Result = $result")
}

class LongestPalindromicSubString {
    var arrayPolindrom: Array<IntArray>?=null

    fun longestPalindrome(s: String): String {
        arrayPolindrom = Array(s.length) {IntArray(s.length) {0}}
        val size = s.length
        if (s.length<=1) return s
        for (i in 0 .. arrayPolindrom!!.size-1) {
            arrayPolindrom!![i][i] = 1
            if (i+1 < size) {
                arrayPolindrom!![i][i+1] = if (s[i]==s[i+1]) 1 else 0
            }
        }
        printArrray()


        // For any polindrom greated than 3
        if (size>2) {
            for (j in 2..size-1) {
                for (i in 0..size-1) {
                    if ( (i+1 < size) && (i!=j) && (abs(j-i)>=2) ) {
                        arrayPolindrom!![i][j] = if ((s[i] == s[j]) && (arrayPolindrom!![i + 1][j - 1] == 1)) 1 else 0
                    }
                }
            }
        }

        var minIndex = 0
        var maxIndex = 0

        var max = 0
        for (i in 0..1) {
          val first = arrayPolindrom!![i].indexOfFirst {
              println("it = $it")
              it==1
          }
          val last = arrayPolindrom!![i].indexOfLast {
              println("it.last = $it")
              it == 1
          }
          println("First = $first, last=$last")
          var polindromLen = if (first==last) 0 else (last-first)
          if (polindromLen>max) {
              max = polindromLen
              minIndex = first
              maxIndex = last
          }
        }

        printArrray()
        return s.substring(minIndex, maxIndex+1)
    }

    fun buildPolindromMatrix() {
    }

    fun printArrray() {
        for (i in 0 until arrayPolindrom!!.size) {
            for (j in 0 until arrayPolindrom!![i].size) {
                val value = arrayPolindrom!![i][j]
                print("$value,")
            }
            println("")
        }
    }
}