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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0,head);
        ListNode previous = dummy;
        ListNode current = head;
        if(left == right) return head;
      
            for(int i =1 ; i<left ; i++){
                previous = previous.next;
                

            }
            current= previous.next;
            for(int i= left;i<right;i++){
                ListNode next = current.next;
                current.next = next.next;
                next.next = previous.next;
                previous.next = next;
            }
           

       
         return dummy.next;
    }
}