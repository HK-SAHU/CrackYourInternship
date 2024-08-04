class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class RearrangeAGivenLinkedListInPlace {

    public static ListNode reverse(ListNode head) {
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

    public void reorderList(ListNode head) {
        // Finding the mid of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        ListNode newHead = reverse(slow.next);
        slow.next = null;
        slow = head;
        fast = head;
        while (newHead != null) {
            ListNode temp = newHead;
            newHead = newHead.next;
            slow = slow.next;
            temp.next = slow;
            fast.next = temp;
            fast = fast.next.next;
        }
    }

    // Method to insert a new node at the end of the list
    public static ListNode insertAtEnd(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        return head;
    }

    // Method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RearrangeAGivenLinkedListInPlace solution = new RearrangeAGivenLinkedListInPlace();
        ListNode head = null;
        
        // Creating a linked list
        head = insertAtEnd(head, 1);
        head = insertAtEnd(head, 2);
        head = insertAtEnd(head, 3);
        head = insertAtEnd(head, 4);
        head = insertAtEnd(head, 5);

        System.out.println("Original Linked List:");
        printList(head);

        // Reordering the list
        solution.reorderList(head);

        System.out.println("Reordered Linked List:");
        printList(head);
    }
}
