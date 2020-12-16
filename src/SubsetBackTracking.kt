fun main() {
    var subsetBackTracking = SubsetBackTracking()

    var nums = arrayOf(1,2,3)

    subsetBackTracking.subSet(nums)

    print("Result = ${subsetBackTracking.output}")


}

class SubsetBackTracking {

    var output = arrayListOf<ArrayList<Int>>()
    var n = 0
    var k = 0

    fun backtrack(first: Int, curr: ArrayList<Int>, nums: Array<Int>) {
        if (curr.size==k) {
            output.add(ArrayList(curr))
        }
        for (i in first until n) {
            curr.add(nums[i])
            backtrack(i+1, curr, nums)
            curr.remove(curr.size-1)
        }
    }

    fun subSet(nums: Array<Int>): List<List<Int>> {
        n = nums.size
        for (i in 0..n) {
            k = i
            backtrack(0,ArrayList<Int>(), nums)
        }

        return output
    }
}