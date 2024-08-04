class Node{
    int val;
    Node next;
    Node(int val){
        this.val= val;
        next=null;
    }
}

public class rearrangeLinkedListZigZag {
    static Node head= null; 
    static int temp=0;

    public static void zigzag(Node head){
        boolean flag= true;
        Node curr=head;

        while(curr!=null && curr.next!=null){
            if(flag){
                if(curr.val>curr.next.val){
                    temp= curr.val;
                    curr.val= curr.next.val;
                    curr.next.val= temp;

                }
            }
            else{
                if(curr.val < curr.next.val){
                    temp= curr.val;
                    curr.val=curr.next.val;
                    curr.next.val= temp; 
                }
            }
            curr= curr.next;
            flag=(!flag);
        }
        printList(head);

    }

    public static  void insertAtEnd(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        rearrangeLinkedListZigZag list = new rearrangeLinkedListZigZag();
        
        // Insert nodes at the end
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);

        // Print the original list
        System.out.print("Original List: ");
        printList(head);

        // Print the list in zigzag manner
        System.out.print("Zigzag List: ");
        zigzag(head);
    }  
}
