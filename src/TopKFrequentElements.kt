import java.util.*

/*
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
You can return the answer in any order.
 */

fun main() {
    val topKFrequentElements = TopKFrequentElements()

    //val nums = intArrayOf(1,1,1,2,2,3)
    val nums = intArrayOf(1)

    val result = topKFrequentElements.topKFrequent(nums, 1)

    result.forEach {
        print("$it ")
    }

}

class TopKFrequentElements {

    var freq = hashMapOf<Int, Int>()
    val freqSet = PriorityQueue<Map.Entry<Int, Int>>(kotlin.Comparator { o1, o2 -> o2.value.compareTo(o1.value) })

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val result = arrayListOf<Int>()
        for (i in nums.indices) {
            if (!freq.containsKey(nums[i])) {
                freq[nums[i]] = 1
            } else {
                freq[nums[i]]?.let {
                    freq[nums[i]] = freq[nums[i]]!!+1
                }
            }
        }

        freq.forEach {
            freqSet.add(it)
        }
        for (i in 0 until k) {
            val element = freqSet.remove()
            result.add(element.key)
        }
        return result.toIntArray()
    }

}