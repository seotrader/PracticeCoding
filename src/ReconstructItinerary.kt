import com.sun.org.apache.xpath.internal.operations.Bool
import java.util.*
import kotlin.collections.ArrayList

/*
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:

If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
One must use all the tickets once and only once.
Example 1:

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
Example 2:

Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.
 */


fun main() {
    val reconstructItinerary = ReconstructItinerary()
}

class ReconstructItinerary {
    private val ticketsMap = hashMapOf<String, ArrayList<String>>()
    private val visitedMap = hashMapOf<String, Array<Boolean>>()
    var result = arrayListOf<String>()
    var counter=0
    var size=0

    fun findItinerary(tickets: List<List<String>>): List<String> {
        size = tickets.size
        tickets.forEach {
            if (ticketsMap[it[0]]==null) {
                ticketsMap[it[0]] = arrayListOf(it[1])
            } else {
                ticketsMap[it[0]]?.add(it[1])
            }
        }

        // Set the booolean array
        ticketsMap.forEach {
            it.value.sort()
            visitedMap[it.key] = Array<Boolean>(it.value.size) { false }
        }

        println("ticketsMap = $ticketsMap")
        println("visitedMap = $visitedMap")

        // Backtrack
        var route = LinkedList<String>()

        route.add("JFK")

        backtrack("JFK", route)
        return result
    }

    fun backtrack(currentNode: String, route: LinkedList<String>): Boolean {
        println("${route.size}, size=$size")
        /// We had all flights
        if (route.size == size+1) {
            println("we have a solution. $route")
            result = route.toList() as ArrayList<String>
            return true
        }

        if (!ticketsMap.containsKey(currentNode)) return false

        var i = 0
        var visitedArray = visitedMap[currentNode]

        // Run on each node and try to find a solution
        ticketsMap[currentNode]?.forEach {nextNode->
            visitedArray?.let {
                if (!it[i]) {

                    it[i] = true
                    println("Adding $nextNode. i=$i route=$route, route.size = ${route.size}")
                    route.add(nextNode)
                    val ret = backtrack(nextNode, route)

                    // We didn't find a solution, backtrack
                    if (ret) return true

                    val removedVal = route.pollLast()
                    println("remove $removedVal")
                    it[i] = false


                }
                ++i
            }
        }

        return false

    }
}