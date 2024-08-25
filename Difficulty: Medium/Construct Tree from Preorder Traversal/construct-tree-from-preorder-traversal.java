//{ Driver Code Starts
//Initial template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
class GFG
{
    public static void inorder(Node root)
    {
        if(root==null)
        return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String args[])throws IOException 
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());

            String input_line1[] = read.readLine().trim().split("\\s+");
            int pre[] = new int[n];
            for(int i=0;i<n;i++){
                pre[i] = Integer.parseInt(input_line1[i]);
            }

            String input_line2[] = read.readLine().trim().split("\\s+");
            char preLN[] = new char[n];
            for(int i=0;i<n;i++){
                preLN[i] = input_line2[i].charAt(0);
            }
            Solution obj = new Solution();
            Node root = obj.constructTree(n,pre,preLN);
            inorder(root);
            System.out.println();
        }
    }
}

// } Driver Code Ends


/*class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/
class Solution{
    // Index to keep track of the current node in pre[] and preLN[]
    private int index = 0;

    Node constructTree(int n, int pre[], char preLN[]) {
        // Start constructing the binary tree from the first node
        return constructTreeUtil(n, pre, preLN);
    }

    private Node constructTreeUtil(int n, int pre[], char preLN[]) {
        // Base case: if index is out of bounds, return null
        if (index == n) {
            return null;
        }

        // Create a new node with the current value in pre[]
        Node node = new Node(pre[index]);

        // If the current node is a leaf node, just return it
        if (preLN[index] == 'L') {
            index++;
            return node;
        }

        // Move to the next index as we are processing this node
        index++;

        // If the current node is not a leaf node, recursively construct the left and right subtrees
        node.left = constructTreeUtil(n, pre, preLN);
        node.right = constructTreeUtil(n, pre, preLN);

        // Return the constructed subtree rooted at this node
        return node;
    }
}