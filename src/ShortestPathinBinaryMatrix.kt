import java.util.*
import kotlin.collections.ArrayList


// [[1,0,0],[1,1,0],[1,1,0]]

fun main() {
    var shortesPathinBinaryMatrix = ShortestPathinBinaryMatrix()

    val matrix = arrayListOf<IntArray>()
    matrix.add(intArrayOf(1,0,0))
    matrix.add(intArrayOf(1,1,0))
    matrix.add(intArrayOf(1,1,0))

    for (i in 0..matrix.size-1) {
        for (j in 0..matrix.size-1) {
            print("${matrix[i][j]},")
        }
        println("")
    }

    val result = shortesPathinBinaryMatrix.shortestPathBinaryMatrix(matrix.toTypedArray())
    println("result = $result")
}

data class Point(val y: Int,val x: Int)
data class DistanceInfo(val p: Point, val distance: Int)

class ShortestPathinBinaryMatrix {
    val queue: Queue<Point> = LinkedList<Point>()
    var shortedDistance = Int.MAX_VALUE
    val visited = hashMapOf<Point, Boolean>()
    val distanceMap = hashMapOf<Point, DistanceInfo>()
    var matrixSize = 0

    fun isValid(point: Point, grid: Array<IntArray>): Boolean {
        if (point.x<0 || point.x>=matrixSize || point.y<0 || point.y>=matrixSize || grid[point.y][point.x] == 1) return false
        return true
    }

    fun getNeighboors(point: Point, grid: Array<IntArray>): ArrayList<Point> {
        val result = arrayListOf<Point>()
        val point1 = Point(point.y-1,point.x-1)
        if (isValid(point1, grid)) result.add(point1)
        val point2 = Point(point.y-1,point.x)
        if (isValid(point2, grid)) result.add(point2)
        val point3 = Point(point.y-1,point.x+1)
        if (isValid(point3, grid)) result.add(point3)
        val point4 = Point(point.y,point.x-1)
        if (isValid(point4, grid)) result.add(point4)
        val point5 = Point(point.y,point.x+1)
        if (isValid(point5, grid)) result.add(point5)
        val point6 = Point(point.y+1,point.x-1)
        if (isValid(point6, grid)) result.add(point6)
        val point7 = Point(point.y+1,point.x)
        if (isValid(point7, grid)) result.add(point7)
        val point8 = Point(point.y+1,point.x+1)
        if (isValid(point8, grid)) result.add(point8)
        return result
    }

    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        // Init the visit map
        matrixSize = grid.size
        for (i in 0..matrixSize-1) {
            for (j in 0..matrixSize-1) {
                visited[Point(i,j)] = false
            }
        }

        val firstPoint = Point(0, 0)

        if (grid[firstPoint.y][firstPoint.x] == 1) return -1
        if (grid[firstPoint.y][firstPoint.x] == 0 && matrixSize==1) return 1

        queue.add(firstPoint)
        distanceMap[firstPoint] = DistanceInfo(firstPoint, 1)

        while (!queue.isEmpty()) {
            val currentPoint = queue.poll()
            val neighbors = getNeighboors(currentPoint, grid)
            neighbors.forEach {
                var distance = 0
                distanceMap[currentPoint]?.let { distanceInfo->
                    distance = distanceInfo.distance+1
                    if (visited[it]==false)
                        distanceMap[it] = DistanceInfo(it, distance)
                }
                if (it == Point(matrixSize-1, matrixSize-1)) {
                    if (shortedDistance>distance) {
                        shortedDistance = distance
                        queue.add(it)
                    }
                } else {
                    if (visited[it]==false) {
                        queue.add(it)
                        visited[it] = true
                    }
                }
            }
        }

        return if (shortedDistance== Int.MAX_VALUE) -1 else shortedDistance

    }
}