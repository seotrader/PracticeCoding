import java.util.*
import kotlin.collections.ArrayList


fun main() {
    var solution = SolutionPermutations()

    var nums = intArrayOf(1,2,3)

    print("Permute = ${solution.permute(nums)}")
}

class SolutionPermutations {

    var outPut = arrayListOf<ArrayList<Int>>()

    // N - number of elements in the original array
    // nums - the original array
    // output - the output array with all the possible permutations
    // first - the current index we are working on now, until we get to index n
    fun backTrack(n: Int,
                  nums: ArrayList<Int>,
                  output: ArrayList<ArrayList<Int>>,
                  first: Int) {
        // if all integers are used up, we have a new permutation
        if (first === n) {
            println("nums = $nums")
            output.add(ArrayList<Int>(nums))
        }
        for (i in first until n) {
            // place i-th integer first
            // in the current permutation
            Collections.swap(nums, first, i)
            // use next integers to complete the permutations
            backTrack(n, nums, output, first + 1)
            // backtrack
            Collections.swap(nums, first, i)
        }
    }

    fun permute(nums: IntArray): List<List<Int>> {
        val n = nums.size
        var numsArray = arrayListOf<Int>()

        nums.forEach {
            numsArray.add(it)
        }

        backTrack(n, numsArray, outPut, 0)
        return outPut
    }
}