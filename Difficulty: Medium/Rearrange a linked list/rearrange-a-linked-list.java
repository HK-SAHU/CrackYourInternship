//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends
/*

class Node {

    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
This is method only submission.
You only need to complete the below method.
*/
class Solution {

    // Should rearrange given linked list such that all even
    // positioned Nodes are before odd positioned.
    // Returns nothing
    void rearrangeEvenOdd(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node odd = head;
        Node even = head.next;
        Node evenFirst = even; // Store the starting node of even list

        while (true) {
            if (odd == null || even == null || even.next == null) {
                odd.next = evenFirst;
                break;
            }

            // Connecting odd nodes
            odd.next = even.next;
            odd = even.next;

            // If no more even nodes after current odd
            if (odd.next == null) {
                even.next = null;
                odd.next = evenFirst;
                break;
            }

            // Connecting even nodes
            even.next = odd.next;
            even = odd.next;
        }
    }
}


//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            new Solution().rearrangeEvenOdd(head);
            printList(head);
        }
    }
}

// } Driver Code Ends