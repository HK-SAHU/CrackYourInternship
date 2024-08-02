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
    
    public static ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr= head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next= prev;
            prev=curr;
            curr= next;
        }
        return prev;
    }
    
    public void reorderList(ListNode head) {
        
        // finding the mid of the linked list
        ListNode slow=head;
        ListNode fast= head;
        while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast= fast.next.next;
        }
        
        // reverse the second half of the linkedlist
       
        ListNode newHead= reverse(slow.next);
        slow.next= null;
        slow=head;
        fast= head;
        while(newHead!=null){
            ListNode temp= newHead;
            newHead= newHead.next;
            slow= slow.next;
            temp.next=slow;
            fast.next= temp;
            fast= fast.next.next;
            
        }
        
        
    }
}