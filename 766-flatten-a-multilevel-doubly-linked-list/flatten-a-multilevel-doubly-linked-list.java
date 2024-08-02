/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;

        Node pseudoHead = new Node(0);
        pseudoHead.next = head;
        head.prev = pseudoHead;

        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                Node next = curr.next;

                Node childHead = curr.child;
                curr.next = childHead;
                childHead.prev = curr;
                curr.child = null;

                Node childTail = childHead;
                while (childTail.next != null) {
                    childTail = childTail.next;
                }
                childTail.next = next;
                if (next != null) {
                    next.prev = childTail;
                }
            }
            curr = curr.next;
        }

        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }
}