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
    public ListNode reverseList(ListNode head){
        ListNode prev= null;
        ListNode curr= head;
        while(curr!=null){
            ListNode next= curr.next;
            curr.next= prev;
            prev=curr;
            curr= next;
        }
        return  prev;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy= new ListNode(0);
        ListNode curr=dummy;
        ListNode temp1= reverseList(l1);
        ListNode temp2= reverseList(l2);
        int carry=0;
        while(temp1!= null || temp2!= null){
            int val1 = (temp1!=null)?temp1.val:0;
            int val2 = (temp2!= null)? temp2.val:0;
            
            int sum=carry+val1+ val2;
            carry= sum/10;
            curr.next= new ListNode(sum%10);
            curr= curr.next;
            if(temp1!=null) temp1= temp1.next;
            if(temp2!= null) temp2= temp2.next;
        }
        if(carry>0){
            curr.next= new ListNode(carry);
        }
        return reverseList(dummy.next);
    }
}