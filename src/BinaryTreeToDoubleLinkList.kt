fun main() {
    var binaryTree = BinaryTreeToDoubleLinkList()
    var tree = Node(5)

    var list = binaryTree.treeToDoublyList(tree)
}
class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
}

class BinaryTreeToDoubleLinkList {
    var lastElement: Node?=null

    var arrTree = arrayListOf<Node>()

    fun treeToDoublyList(root:Node?): Node? {
        var head = root
        if (root == null) return null
        bstScan(root)

        arrTree[0].left = arrTree[arrTree.size - 1]
        if (arrTree.size > 1) {
            arrTree[0].right = arrTree[1]
            arrTree[arrTree.size - 1].right = arrTree[0]
            if (arrTree.size==2) arrTree[arrTree.size - 1].left = arrTree[arrTree.size -2]
        } else if (arrTree.size==1) {
            arrTree[0].right = arrTree[0]
        }

        if (arrTree.size>2) {
            arrTree[arrTree.size-1].left = arrTree[arrTree.size-2]
            for (i in 1 until arrTree.size-1) {
                arrTree[i].left = arrTree[i-1]
                arrTree[i].right = arrTree[i+1]

            }
        }
        return arrTree[0]
    }

    fun bstScan(root: Node?) {
        root?.let{
            bstScan(it.left)
            arrTree.add(it)
            bstScan(it.right)
        }

    }
}
