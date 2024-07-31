//{ Driver Code Starts
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
/*Node is defined as
class Node
{
    int data;
    Node next;
    Node(int data) {
        this.data=data;
        this.next = null;
    }
}*/

class Solution {
    
    
    private static final long MOD = 1000000007;
    
    public long multiplyTwoLists(Node first, Node second) {
        long num1= getNumber(first);
        long num2= getNumber(second);
        
        return (num1* num2)%MOD;
    }
    
    public static long getNumber(Node head){
        long num=0;
        while(head!=null){
            num= (num * 10 % MOD +head.data)%MOD;
            head= head.next;
        }
        return num;
    }
    
    // public static int intToLinkedList(int num){
    //     Node dummy= new Node(0);
    //     Node current= dummy;
    //     while(num>0){
    //         current.next=new Node(num%10);
    //         num/=10;
    //         current= current.next;
    //     }
    //     return reverseList(dummy.next);
    // }
    
    // public static Node reverseList(Node head){
    //     Node prev=null;
    //     Node current = head;
    //     while(current!=null){
    //         Node temp= cuurent.next;
    //         current.next=prev;
    //         prev=current;
    //         current= nextTemp;
    //     }
    //     return prev;
    // }
}

//{ Driver Code Starts.

public class GFG {
    public static Node newNode(int data) { return new Node(data); }

    public static void push(Node[] head_ref, int new_data) {
        Node new_Node = newNode(new_data);
        new_Node.next = head_ref[0];
        head_ref[0] = new_Node;
    }

    public static void reverse(Node[] r) {
        Node prev = null;
        Node cur = r[0];
        Node nxt;
        while (cur != null) {
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        r[0] = prev;
    }

    public static void freeList(Node Node) {
        Node temp;
        while (Node != null) {
            temp = Node;
            Node = Node.next;
            // In Java, garbage collection takes care of freeing memory.
        }
    }

    public static void printList(Node Node) {
        while (Node != null) {
            System.out.print(Node.data + " ");
            Node = Node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            Node[] first = new Node[1];
            Node[] second = new Node[1];
            first[0] = null;
            second[0] = null;

            String input = sc.nextLine();
            String[] arr = input.split(" ");
            for (String s : arr) {
                push(first, Integer.parseInt(s));
            }

            String input2 = sc.nextLine();
            String[] brr = input2.split(" ");
            for (String s : brr) {
                push(second, Integer.parseInt(s));
            }

            reverse(first);
            reverse(second);

            Solution ob = new Solution();
            long res = ob.multiplyTwoLists(first[0], second[0]);
            System.out.println(res);

            // Free list is not necessary in Java
        }

        sc.close();
    }
}

// } Driver Code Ends