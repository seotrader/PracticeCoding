import com.sun.org.apache.xpath.internal.operations.Bool

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
    private val visited = hashMapOf<String, Boolean>()
    var result = arrayListOf<String>()
    var counter=0
    var size=0

    fun findItinerary(tickets: List<List<String>>): List<String> {
        size = tickets.size
        tickets.forEach {
            if (ticketsMap[it[0]].isNullOrEmpty()) {
                ticketsMap[it[0]] = arrayListOf(it[1])
            } else {
                ticketsMap[it[0]]?.add(it[1])
            }
        }
        ticketsMap.values.forEach {
            it.sort()
        }
        println("Tickets = $ticketsMap")

        dfs("", "JFK")


        return result
    }

    fun dfs(orig: String, node: String) {
        if (counter==4) return
        if (orig != "") ticketsMap[orig]?.remove(node)
        println("deleting $node from $orig")
        visited[node] = true
        counter++
        if (ticketsMap[node]?.isEmpty()!!) return
        result.add(node)
        ticketsMap[node]?.forEach {
            dfs(node, it)
        }
    }

}