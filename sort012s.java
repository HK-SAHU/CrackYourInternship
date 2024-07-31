import java.util.LinkedList;

public class sort012s {
    static Node head;

    public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val= val;
            this.next=null;
        }
    }

    public void sortList(){
        int[] count={0,0,0};
        Node ptr=head;

        /* count total number of '0', '1' and '2'
        * count[0] will store total number of '0's
        * count[1] will store total number of '1's
        * count[2] will store total number of '2's  */

        while(ptr!=null){
            count[ptr.val]++;
            ptr=ptr.next;
        }
        int i=0;
        ptr=head;
        while(ptr!=null){
            if(count[i]==0){
                i++;
            }
            else{
                ptr.val=i;
                count[i]--;
                ptr=ptr.next;
            }
        }

    }

    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
  
        /* 3. Make next of new Node as head */
        new_node.next = head;
  
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
 
    /* Function to print linked list */
    public static void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.val+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
 
     /* Driver program to test above functions */
    public static void main(String args[])
    {
        // LinkedList llist = new LinkedList();

        sort012s llist= new sort012s();
         
        /* Constructed Linked List is 1->2->3->4->5->6->7->
           8->8->9->null */
        llist.push(0);
        llist.push(1);
        llist.push(0);
        llist.push(2);
        llist.push(1);
        llist.push(1);
        llist.push(2);
        llist.push(1);
        llist.push(2);
         
        System.out.println("Linked List before sorting");
        llist.printList();
         
        llist.sortList();
 
        System.out.println("Linked List after sorting");
        llist.printList();
    }
}
