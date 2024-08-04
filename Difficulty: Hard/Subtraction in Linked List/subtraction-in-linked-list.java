//{ Driver Code Starts
import java.util.Scanner;
import java.math.*;

// Node Class
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

// Linked List Class
class LinkedList {
    Node head;
    Node tail;

    LinkedList() {
        head = null;
        tail = null;
    }

    // creates a new node with given value and appends it at the end of the linked list
    void insert(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            tail.next = new Node(val);
            tail = tail.next;
        }
    }
}


public class Main {
    static void printList(Node n) 
    {
        while (n != null) {
            System.out.print(n.data);
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; ++i) {
            int n = sc.nextInt();
            LinkedList LL1 = new LinkedList();
            String l1 = sc.next();
            for (int j = 0; j < n; ++j) {
                int x = Character.getNumericValue(l1.charAt(j));
                LL1.insert(x);
            }

            int m = sc.nextInt();
            LinkedList LL2 = new LinkedList();
            String l2 = sc.next();
            for (int j = 0; j < m; ++j) {
                int x = Character.getNumericValue(l2.charAt(j));
                LL2.insert(x);
            }

            Solution ob = new Solution();
            Node res = ob.subLinkedList(LL1.head, LL2.head);
            printList(res);
        }
    }
}

// } Driver Code Ends


/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    Node reverseList(Node head){
        Node prev= null;
        Node curr= head;
        while(curr!=null){
            Node next= curr.next;
            curr.next= prev;
            prev= curr;
            curr= next;
        }
        return prev;
    }
    
    Node removeLeadingZeros(Node head){
        while(head!=null && head.data==0){
            head= head.next;
        }
        return head;
    }
    
    private boolean isSmaller(Node head1, Node head2) {
        int len1 = getLength(head1);
        int len2 = getLength(head2);

        if (len1 < len2) {
            return true;
        } else if (len1 > len2) {
            return false;
        }

        // If lengths are the same, compare digit by digit
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                return true;
            } else if (head1.data > head2.data) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return false;
    }

    private int getLength(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
    
    private Node subtractLists(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node curr = dummy;

        head1 = reverseList(head1);
        head2 = reverseList(head2);

        int borrow = 0;

        while (head1 != null || head2 != null) {
            int a = (head1 != null) ? head1.data : 0;
            int b = (head2 != null) ? head2.data : 0;

            int sub = a - b - borrow;

            if (sub < 0) {
                sub += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            curr.next = new Node(sub);
            curr = curr.next;

            if (head1 != null) head1 = head1.next;
            if (head2 != null) head2 = head2.next;
        }

        Node result = reverseList(dummy.next);

        return result;
    }
    
    public Node subLinkedList(Node head1, Node head2) {
        // Remove leading zeros
        head1 = removeLeadingZeros(head1);
        head2 = removeLeadingZeros(head2);

        // Determine which list represents the larger number
        if (isSmaller(head1, head2)) {
            // Ensure we always subtract the smaller number from the larger number
            Node temp = head1;
            head1 = head2;
            head2 = temp;
        }

        // Perform the subtraction
        Node result = subtractLists(head1, head2);

        // Remove any leading zeros from the result
        result = removeLeadingZeros(result);

        // If the result is empty, return a node with data 0
        if (result == null) {
            return new Node(0);
        }

        return result;
    }
}
        
