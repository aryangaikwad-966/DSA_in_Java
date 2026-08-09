/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
    while(fast!=null && fast.next!= null){
        slow = slow.next;
        fast = fast.next.next;
    }
    ListNode previous = null;
    ListNode current = slow.next;
    slow.next = null;
    while(current!=null){
        ListNode next = current.next;
        current.next = previous;
        previous = current;
        current = next;

    }
    ListNode first = head;
    ListNode second = previous;
    while(second!=null){
        ListNode next1 = first.next;
        ListNode next2 = second.next;
  
    first.next = second;
    second.next = next1;
    
    first = next1;
    second = next2;
    }
    }
}