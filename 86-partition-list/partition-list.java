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
    public ListNode partition(ListNode head, int x) {
        // Create two new dummy nodes to act as the head of the 'less' and 'greater' lists
        ListNode lessDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);

        // Pointers to the current end of the 'less' and 'greater' lists
        ListNode less = lessDummy;
        ListNode greater = greaterDummy;

        // Traverse the original list
        while (head != null) {
            if (head.val < x) {
                // If the current node's value is less than x, add it to the 'less' list
                less.next = head;
                less = less.next;
            } else {
                // If the current node's value is greater than or equal to x, add it to the 'greater' list
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }

        // Ensure the 'greater' list ends properly
        greater.next = null;

        // Connect the 'less' list with the 'greater' list
        less.next = greaterDummy.next;

        // The head of the new list is the next node after the dummy node
        return lessDummy.next;
    }
}