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
    public ListNode reverseList(ListNode head) { 
        // if(head==null) return null;
        // if(head.next==null) return head;
        // ListNode newHead=reverseList(head.next);
        // head.next.next=head;    //interchanging the connections
        // head.next=null;
        // return newHead;
        
        ////////////////////////////////// Iterative ///////////////////////////////////
        
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode curr = head;
        ListNode prev= null;
        ListNode after= null;
        while(curr!=null ){
            after=curr.next;
            curr.next=prev;
            prev=curr;
            curr= after;
        }
        return prev;
    }
}