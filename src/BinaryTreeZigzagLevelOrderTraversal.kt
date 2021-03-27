/*
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
 */

fun main() {
    val binaryTreeZigzagLevelOrderTraversal = BinaryTreeZigzagLevelOrderTraversal()
}

class BinaryTreeZigzagLevelOrderTraversal {
    var zigzag = 0
    val result = arrayListOf<List<Int>>()
    val levels = hashMapOf<Int, ArrayList<Int>>()
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        helper(root, 0)
        levels.keys.forEach {
            levels[it]?.let { it1 -> result.add(it1) }
        }
        return result
    }

    fun helper(root: TreeNode?, level: Int) {
        if (root == null) return
        if (levels.containsKey(level)) {
            levels[level]?.add(root.`val`)
        } else {
            val levelList = arrayListOf<Int>()
            levelList.add(root.`val`)
            levels[level] = levelList
        }
        if (zigzag%2 == 0) {
            zigzag++
            helper(root.right, level+1)
            helper(root.left, level+1)
        } else {
            zigzag++
            helper(root.left, level+1)
            helper(root.right, level+1 )
        }
    }

}