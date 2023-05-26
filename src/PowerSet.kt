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
    var solutionPwerSet = SolutionPowerSet()

    var nums = intArrayOf(1,2,3)

    println("subsets2 = ${solutionPwerSet.subsets2(nums)}")
}

class SolutionPowerSet {
    fun subsets2(nums: IntArray): List<List<Int>> {
        val result = arrayListOf<List<Int>>()
        result.add(arrayListOf())
        for (i in nums) {
            val newSet = arrayListOf<List<Int>>()
            for (set in result) {
                // get set before
                var setsBefore = ArrayList<Int>(set)
                setsBefore.add(i)
                newSet.add(setsBefore)
            }
            for (set in newSet) {
                result.add(set)
            }
        }
        return result
    }
}
