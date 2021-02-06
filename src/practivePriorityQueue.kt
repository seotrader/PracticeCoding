import java.util.*

fun main() {
    val queue = PriorityQueue<Int>(kotlin.Comparator { o1, o2 ->
        o2.compareTo(o1)
    })

    queue.add(5)
    queue.add(1)
    queue.add(3)

    println("queue.poll = ${queue.poll()}")
    println("queue.poll = ${queue.poll()}")
    println("queue.poll = ${queue.poll()}")

    val pointsQueue = PriorityQueue<Point>(kotlin.Comparator { o2, o1 ->
        when {
            o1.y>o2.y -> 1
            o1.y==o2.y && o1.x>o2.x -> 1
            o1.y==o2.y && o1.x==o2.x -> 0
            o1.y<o2.y -> -1
            o1.y==o2.y && o1.x<o2.x -> -1
            else -> 1
        }
    })
    pointsQueue.add(Point(1,7))
    pointsQueue.add(Point(1, 1))
    pointsQueue.add(Point(5, 1))
    pointsQueue.add(Point(7, 1))
    pointsQueue.add(Point(1, 6))

    println("queue.poll = ${pointsQueue.poll()}")
    println("queue.poll = ${pointsQueue.poll()}")
    println("queue.poll = ${pointsQueue.poll()}")
    println("queue.poll = ${pointsQueue.poll()}")
    println("queue.poll = ${pointsQueue.poll()}")
}