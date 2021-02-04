/*
Given the root of a binary tree, return all duplicate subtrees.

For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with the same node values.
 */

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 *
 */

fun main() {
    val findDuplicateSubtrees = FindDuplicateSubtrees()
}
class FindDuplicateSubtrees {
    val mapTree = hashMapOf<ArrayList<Int>, TreeNode?>()
    val resultList = mutableSetOf<TreeNode?>()

    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
        helper(root)
        return resultList.toList()
    }

    fun helper(root: TreeNode?): ArrayList<Int> {
        if (root == null) {
            println("Returns root")
            return arrayListOf()
        }
        if (root.left == null && root.right == null) {
            println("return setof")
            if (mapTree.containsKey(arrayListOf(root.`val`))) {
                mapTree.remove(arrayListOf(root.`val`))
                mapTree[arrayListOf(root.`val`)] = root
                resultList.add(root)
            } else {
                mapTree[arrayListOf(root.`val`)] = root
            }
            return arrayListOf(root.`val`)
        }
        val leftTree = helper(root.left)
        val rightTree = helper(root.right)

        println("Root value = ${root.`val`}")
        println("Left tree = $leftTree")
        println("Right tree = $rightTree")


        val result = arrayListOf<Int>()
        result.add(root.`val`)
        result.addAll(leftTree)
        result.addAll(rightTree)
        println("result = $result")
        if (mapTree.containsKey(result)) {
            resultList.add(root)
        } else {
            mapTree[result] = root
        }
        return result
    }
}

