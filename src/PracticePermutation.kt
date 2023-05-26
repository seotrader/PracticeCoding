fun main() {
    var numbers = intArrayOf(1,2,3,4)
    val practivePermutation = PractivePermutation()

    val result = practivePermutation.returnPermutations(numbers)

    result.forEach {
        it.forEach { i ->
            print("$i, ")
        }
        println("")
    }
}

class PractivePermutation {
    var result = arrayListOf<IntArray>()

    fun returnPermutations(numbers: IntArray): ArrayList<IntArray> {
        backtrack(numbers, 0)
        return result
    }

    fun backtrack(arr: IntArray, startPos: Int) {
        if (startPos == arr.size-1) {
            result.add(arr.clone())
        }
        for (i in startPos..arr.size-1) {
           arr[i] = arr[startPos].also {
               arr[startPos] = arr[i]
           }
            backtrack(arr,startPos+1)
            arr[i] = arr[startPos].also {
                arr[startPos] = arr[i]
            }
        }
    }

}