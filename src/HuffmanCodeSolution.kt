import java.util.*

fun main() {
    val charArray = charArrayOf('f', 'c', 'b', 'd', 'e', 'a')
    val charFreq = intArrayOf(45, 12, 9, 13, 16, 5)
    val rootNode: HNode? = HNode.encode(charArray, charFreq)
    HNode.printCode(rootNode, "")
    println("Huffman code for c = ${HNode.getCode('c')}")
}

class HNode {

    var freq: Int=0
    var char: Char=' '
    var left: HNode?=null
    var right: HNode?=null

    companion object {
        var huffmanMap = hashMapOf<Char, String>()

        fun getCode(char: Char): String? {
            return huffmanMap[char]
        }

        fun printCode(rootnode: HNode?, code: String) {
            if (rootnode?.left==null  && rootnode?.right==null) {
                println("${rootnode?.char} = $code")
                rootnode?.let{
                    huffmanMap[it.char] = code
                }

                return
            }

            printCode(rootnode?.left, "$code${0}")
            printCode(rootnode?.right, "$code${1}")
        }

        fun encode(charArray: CharArray, freqArray: IntArray): HNode? {
            val priorityQueue = PriorityQueue<HNode> { a, b ->
                a.freq-b.freq
            }

            // First enter all elements to the priority queue
            charArray.forEachIndexed { index, c ->
                val node = HNode()
                node.char = c
                node.freq = freqArray[index]
                priorityQueue.add(node)
            }

            println("priorityQueue = $priorityQueue")

            while (priorityQueue.size>1) {
                val first = priorityQueue.poll()
                val second = priorityQueue.poll()
                println("First = ${first.char}, second=${second.char}")
                val newNode = HNode()
                newNode.freq = first.freq+second.freq
                newNode.char = '-'
                newNode.left = first
                newNode.right = second
                priorityQueue.add(newNode)
            }

            println("priorityQueue.size = ${priorityQueue.size}")

            return priorityQueue.poll()
        }


    }
}