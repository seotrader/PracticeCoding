import java.util.*


/*
Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.

Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
with the number of occurrence being 4, 3, 2 and 1 respectively.

Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.
 */

fun main() {
    var topKWords = TopKFrequentWords()

    var words = arrayOf("i", "love", "leetcode", "i", "love", "coding")
    var result = topKWords.topKFrequent(words, 2)
    println("Result = $result")

}

class TopKFrequentWords {

    private fun sortByComparator(unsortedMap: Map<String, Int>) : ArrayList<Map.Entry<String, Int>> {
        val list = arrayListOf<Map.Entry<String, Int>>()
        unsortedMap.forEach {
            list.add(it)
        }

        list.sortWith(Comparator { o1, o2 ->
            if (o1.value != o2.value) {
                o2.value.compareTo(o1.value)
            } else {
                o1.key.compareTo(o2.key)
            }

        })
        return list
    }

    var counterMap = hashMapOf<String, Int>()

    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        var list = arrayListOf<String>()
        // First add all the words to a hashMap
        words.forEach {
            if (counterMap.containsKey(it)) {
                counterMap[it] = counterMap[it]!!+1
            } else {
                counterMap[it] = 1
            }
        }
        println("map = $counterMap")
        var sorted = sortByComparator(counterMap)
        for (i in 0 until k) {
            list.add(sorted[i].key)
        }
        return list


    }
}