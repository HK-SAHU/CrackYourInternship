/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA= headA;
        ListNode tempB= headB;
        ListNode found= null;
        int sizeA=0;
        int sizeB=0;
        while(tempA!=null){
            sizeA++;
            tempA= tempA.next;
        }
        while(tempB!=null){
            sizeB++;
            tempB= tempB.next;
        }
        tempA=headA;
        tempB= headB;
        if(sizeA>sizeB){
            for(int i=1;i<=sizeA-sizeB;i++){
                tempA= tempA.next;
            }
        }
        else{
            for(int i=1;i<=sizeB-sizeA;i++){
                tempB= tempB.next;
            }
        }
        while(tempA!=tempB){
            tempA= tempA.next;
            tempB= tempB.next;
        }
        if(tempA==tempB){
            found= tempA;
            return found;
        }
        return found;
    }
}