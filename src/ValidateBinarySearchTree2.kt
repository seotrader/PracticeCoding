class ValidateBinarySearchTree2 {
    var last = Int.MAX_VALUE

    fun isValidBST(root: TreeNode?): Boolean {
        return helper(root)
    }

    fun helper(root: TreeNode?): Boolean {
        if (root == null) return true
        if (!helper(root.left)) return false
        if (root.`val` > last) return false
        last = root.`val`
        if (!helper(root.right)) return false
        return true
    }
}