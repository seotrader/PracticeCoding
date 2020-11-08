/*
Given a linked list, swap every two adjacent nodes and return its head.
You may not modify the values in the list's nodes. Only nodes itself may be changed.
 */

class SwapPairs {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun swapPairs(head: ListNode?): ListNode? {
        if (head==null) return null
        if (head.next==null) return head

        val firstNode = head
        val secondNode = head.next

        // swaping
        firstNode.next = swapPairs(secondNode?.next)
        secondNode?.next = firstNode
        return secondNode
    }
}