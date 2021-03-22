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

    println("subsets = ${solutionPwerSet.subsets(nums)}")
}

class SolutionPowerSet {
    fun subsets(nums: IntArray): List<List<Int>> {
        var output = arrayListOf<List<Int>>()

        // add to output an empty array list --- empty set
        output.add(arrayListOf<Int>())

        for (i in nums) {
            // create a new set, to add to the final result
            var newSet = arrayListOf<List<Int>>()

            for (set in output) {
                // get set before
                var setsBefore = ArrayList<Int>(set)
                // add the number to each of the sets before
                setsBefore.add(i)
                // add the set to the new set
                newSet.add(setsBefore)
            }
            // Add all new sets to the final result
            for (curr in newSet) {
                output.add(curr)
            }
        }

        return output
    }
}
