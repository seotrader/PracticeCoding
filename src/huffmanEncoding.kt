import java.util.PriorityQueue

// node class is the basic structure
// of each node present in the huffman - tree.
class HuffmanNode : Comparable<HuffmanNode> {
    var freq = 0
    var chr = ' '

    var left: HuffmanNode? = null
    var right: HuffmanNode? = null

    companion object {
        // recursive function to print the
        // huffman-code through the tree traversal.
        // Here s is the huffman - code generated.
        fun printCode(root: HuffmanNode) = printCode(root, "")

        fun encode(charArray: CharArray, charFreq: IntArray): HuffmanNode? {
            val numCharacters = charArray.size

            // makes a min-priority queue(min-heap)
            val pQueue = PriorityQueue(numCharacters, HuffmanNode::compareTo)

            for (i in 0 until numCharacters) {
                val huffNode = HuffmanNode()

                huffNode.chr = charArray[i]
                huffNode.freq = charFreq[i]

                huffNode.left = null
                huffNode.right = null

                pQueue.add(huffNode)
            }

            var rootNode: HuffmanNode? = null

            // Here we will extract the two minimum value
            // from the heap each time until
            // its size reduces to 1, extract until
            // all the nodes are extracted.
            while (pQueue.size > 1) {

                val first = pQueue.poll()
                val second = pQueue.poll()
                val newHuffNode = HuffmanNode()

                newHuffNode.freq = first.freq + second.freq
                newHuffNode.chr = '-'

                newHuffNode.left = first
                newHuffNode.right = second

                rootNode = newHuffNode
                pQueue.add(newHuffNode)
            }
            return rootNode
        }

        private fun printCode(root: HuffmanNode, s: String) {
            // base case; if the left and right are null
            // then its a leaf node and we print
            // the code s generated by traversing the tree.
            if (root.left == null
                    && root.right == null
                    && Character.isLetter(root.chr)
            ) {
                println("${root.chr}:$s")
                return
            }

            // if we go to left then add "0" to the code.
            // if we go to the right add"1" to the code.

            // recursive calls for left and
            // right sub-tree of the generated tree.
            printCode(root.left!!, "${s}0")
            printCode(root.right!!, "${s}1")
        }
    }

    override fun compareTo(other: HuffmanNode) =
            this.freq - other.freq
}

fun main(args: Array<String>) {

    val charArray = charArrayOf('a', 'b', 'c', 'd', 'e', 'f')
    val charFreq = intArrayOf(5, 9, 12, 13, 16, 45)

    val rootNode: HuffmanNode? = HuffmanNode.encode(charArray, charFreq)
    HuffmanNode.printCode(rootNode!!)
}