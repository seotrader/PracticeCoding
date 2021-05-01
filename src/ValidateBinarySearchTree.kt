/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.


Constraints:

The number of nodes in the tree is in the range [1, 10^4].
-2^31 <= Node.val <= 2^31 - 1
 */
class ValidateBinarySearchTree {
    fun isValidBST(root: TreeNode?): Boolean {
        return helper(root, Int.MIN_VALUE, Int.MAX_VALUE)
        return false
    }

    fun helper(root: TreeNode?, max: Int?=null, min: Int?=null): Boolean {
        if (root == null) return true
        if (max != null && root.`val` > max) return false
        if (min != null && root.`val` < min) return false
        val left = helper(root.left, root.`val`, null)
        val right = helper(root.right, null, root.`val`)
        return left && right
    }
}