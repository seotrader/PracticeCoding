
import java.util.*

/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

Constraints:

intervals[i][0] <= intervals[i][1]
*/

fun main() {
    var solution = MergeIntervals()

    var array = Array<IntArray>(4) { IntArray(2)}

    array[0] = intArrayOf(1,3)
    array[1] = intArrayOf(8,10)
    array[2] = intArrayOf(2,6)
    array[3] = intArrayOf(15,18)

    solution.print2dArray(array)
    println("\r\n")

    var merged = solution.merge(array)

    solution.print2dArray(merged)
}

class MergeIntervals {

    // In case you to implement Comparator()
    private class IntervalComparator : Comparator<IntArray> {
        override fun compare(a: IntArray, b: IntArray): Int {
            return if (a[0] < b[0]) -1 else if (a[0] == b[0]) 0 else 1
        }
    }

    fun print2dArray(array: Array<IntArray>) {
        array.forEach {
            print("[${it[0]},${it[1]}],")
        }
    }

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        var newInterval = arrayListOf<IntArray>()
        var sortedArray = intervals.sortedBy {
            it[0]
        }

        sortedArray.forEach {
            if (newInterval.isEmpty() || newInterval.last()[1]<it[0]) {
                newInterval.add(it)
                println("Adding [${it[0]},${it[1]}]")
            } else {
                if (it[1] > newInterval.last()[1]) {
                    newInterval.last()[1] = it[1]
                    println("replacing [${it[0]},${it[1]}]")
                } else {
                    println("Do nothing")
                }
            }
        }
        return newInterval.toTypedArray()
    }
}

