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
    public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) return true; // Empty list or single-node list is a palindrome

            ListNode slow = head;
            ListNode fast = head;

            // Move slow to the middle of the list
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // Reverse the second half of the list
            ListNode secondHalf = reverse(slow);
            slow.next = null; // Break the original list from the middle

            // Compare first half with reversed second half
            ListNode p1 = head;
            ListNode p2 = secondHalf;
            while (p1 != null && p2 != null) {
                if (p1.val != p2.val) {
                    return false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
            return true;
        }

        // Helper method to reverse a linked list
        public ListNode reverse(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
}