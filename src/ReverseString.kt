class Solution {
    fun reverseString(s: CharArray): Unit {
        helper(s, 0)
    }

    fun helper(s: CharArray, index: Int): Unit {
        if (index == s.size) return
        helper(s,index+1)
        val newIndex = s.size-1-index
        println("newIndex = $newIndex")
        if (newIndex>=0 && newIndex != index && newIndex<=(s.size-1)/2) {
            val temp = s[index]
            s[index] = s[newIndex]
            s[newIndex] = temp
        }
    }
}