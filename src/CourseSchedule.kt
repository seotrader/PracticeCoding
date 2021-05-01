import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val courseSchedule = CourseSchedule()

}

class CourseSchedule {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        var inDegreeMap = hashMapOf<Int, Int>()
        var adjListMap = hashMapOf<Int, ArrayList<Int>>()

        prerequisites.forEachIndexed { i, value ->
            if (!adjListMap.containsKey(value[1])) {
                adjListMap[value[1]] = arrayListOf()
                adjListMap[value[1]]!!.add(value[0])
            } else {
                adjListMap[value[1]]!!.add(value[0])
            }
            println("${value[0]},${value[1]}")

            if (inDegreeMap.containsKey(value[0])) {
                inDegreeMap[value[0]] = inDegreeMap[value[0]]!!+1
            } else {
                inDegreeMap[value[0]] = 1
            }
        }
        println("inDegreeMap = $inDegreeMap")
        println("adjListMap = $adjListMap")

        // find all the 0 indegree
        var queue = arrayListOf<Int>()

        // add all into the courses
        for (i in 0..numCourses-1) {
            if ( (!inDegreeMap.containsKey(i)) || (inDegreeMap[i]==0)) {
                queue.add(i)
            }
        }
        println("queue = $queue")

        while (!queue.isEmpty()) {
            val pop = queue.removeAt(0)
            var adsList = adjListMap[pop]
            adsList?.forEach {
                println("reducing indegree of $it")
                inDegreeMap[it] = inDegreeMap[it]!!-1
                if (inDegreeMap[it]==0) {
                    queue.add(it)
                }
            }
            inDegreeMap.remove(pop)
        }

        println("inDegreeMap = $inDegreeMap")


        return (inDegreeMap.isEmpty())
    }

    fun printInDegree(arr: Array<Int>) {
        arr.forEach {
            print("$it,")
        }
    }
}