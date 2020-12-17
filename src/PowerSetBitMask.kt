import kotlin.math.pow

/*
Given an integer array nums, return all possible subsets (the power set).

The solution set must not contain duplicate subsets.



Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]


Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10


*/

fun main() {
    var powerSetBitMask = PowerSetBitMask()

    var nums = intArrayOf(1,2,3)

    println("Result = ${powerSetBitMask.subsets(nums)}")
}

class PowerSetBitMask {

    fun subsets(nums: IntArray): List<List<Int>> {
        var output = arrayListOf<List<Int>>()
        val n = nums.size

        for (i in 2.0.pow((n).toDouble()).toInt() until 2.0.pow((n + 1).toDouble()).toInt()) {
            var bitMask = Integer.toBinaryString(i).substring(1)
            var newSet = arrayListOf<Int>()

            // 123
            for (i in 0 until nums.size) {
                if (bitMask[i] == '1') newSet.add(nums[i])
            }
            output.add(newSet)
        }

        return output
    }

}