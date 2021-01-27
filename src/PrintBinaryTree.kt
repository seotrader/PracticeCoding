import java.lang.Math.pow
import kotlin.math.pow

/*
Print a binary tree in an m*n 2D string array following these rules:

The row number m should be equal to the height of the given binary tree.
The column number n should always be an odd number.
The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
Each unused space should contain an empty string "".
Print the subtrees following the same rules.
Example 1:
Input:
1
/
2
Output:
[["", "1", ""],
["2", "", ""]]
Example 2:
Input:
1
/ \
2   3
\
4
Output:
[["", "", "", "1", "", "", ""],
["", "2", "", "", "", "3", ""],
["", "", "4", "", "", "", ""]]
Example 3:
Input:
1
/ \
2   5
/
3
/
4
Output:

[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
Note: The height of binary tree is in the range of [1, 10].
*/

class PrintBinaryTree {
    var maxTreeSize = Int.MIN_VALUE

    fun printTree(root: TreeNode?): List<List<String>> {

        calculateTreeHeight(root, 0)
        val numberOfElements = (2.toDouble().pow(maxTreeSize.toDouble())-1).toInt()
        var arr = Array<Array<String>>(maxTreeSize) { _ -> Array(numberOfElements) { "" } }
        var list = arrayListOf<ArrayList<String>>()
        fill(arr, root, 0, 0, numberOfElements-1)
        arr.forEach {
            list.add(it.toList() as ArrayList<String>)
        }
        return list
    }

    fun fill(arr: Array<Array<String>>, root: TreeNode?, h: Int, l: Int, r: Int) {
        if (root==null) return

        val mid = (h+l)/2
        println("mid = $mid")
        arr[h][mid] = root?.`val`.toString()
        fill(arr, root.left, h+1, l,mid)
        fill(arr, root.right, h+1, mid+1, r)
    }

    fun calculateTreeHeight(root: TreeNode?, height: Int) {
        if (height > maxTreeSize) {
            maxTreeSize = height
        }

        if (root != null) {
            calculateTreeHeight(root.left, height+1)
            calculateTreeHeight(root.right, height+1)
        }

    }
}