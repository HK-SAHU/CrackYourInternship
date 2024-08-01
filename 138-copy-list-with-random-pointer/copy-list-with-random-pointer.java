/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

/*
step1- make a deep copy of the given linked list
step2- connect the alternate nodes of thw two linked list
step3- connect the random of the copied linked list
step4- seprating the list
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node head2= new Node(0);
        Node temp2= head2;
        Node temp1= head;
        //creating deep copy
        while(temp1!=null){
            Node a= new Node(temp1.val);
            temp2.next=a;
            temp2=a;
            temp1= temp1.next;
        }
        head2=head2.next;
        temp2=head2;
        temp1=head;
        //alternate connections
        Node head3= new Node(1);
        Node t=head3;
        while(temp2!=null){
            t.next=temp1;
            t=t.next;
            temp1= temp1.next;
            t.next= temp2;
            t= t.next;
            temp2= temp2.next;
        }
        temp2=head2;
        temp1=head;
        //connect the randoms
        while(temp1!=null){
            if(temp1.random==null) temp2.random=null;
            else temp2.random= temp1.random.next;
            temp1= temp2.next;
            if(temp1!=null) temp2= temp1.next;
        }
        temp2=head2;
        temp1=head;
        // breaking the connected list
        while(temp1!=null){
            temp1.next= temp2.next;
            temp1= temp1.next;
            if(temp1==null) break;
            temp2.next= temp1.next;
            if(temp2.next==null) break;
            temp2= temp2.next;
        }
        return head2;
    }
}