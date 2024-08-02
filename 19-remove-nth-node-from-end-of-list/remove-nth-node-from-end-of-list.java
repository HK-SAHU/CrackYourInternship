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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast =head;
        ListNode slow = head;
        if(head.next==null){
            head= null;
            return head;
        }
       
        for(int i=1; i<=n;i++){
            fast= fast.next;
        }
        if(fast==null){
            head= head.next;
            return head;
        }
        while(fast.next!=null){
            slow= slow.next;
            fast= fast.next;
        }
        slow.next=slow.next.next;
        
        return head;
        
        
        // ListNode dummy= new ListNode(0);
        // dummy.next= head;
        // ListNode fast= dummy;
        // ListNode slow= dummy;
        // for(int i=1; i<=n;i++){
        //     fast= fast.next;
        // }
        // while(fast!=next){
        //     slow= slow.next;
        //     fast= fast.next;
        // }
        // slow.next= slow.next.next;
        // return head;
        
    }
}