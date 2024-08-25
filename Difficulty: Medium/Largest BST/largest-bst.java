//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution{
    
    // Helper class to store information about the subtree
    static class Info {
        int size;           // Size of the subtree
        int min;            // Minimum value in the subtree
        int max;            // Maximum value in the subtree
        int largestBSTSize; // Size of the largest BST in the subtree
        boolean isBST;      // Whether the subtree is a BST
        
        Info(int size, int min, int max, int largestBSTSize, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.largestBSTSize = largestBSTSize;
            this.isBST = isBST;
        }
    }

    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        Info result = largestBstUtil(root);
        return result.largestBSTSize;
    }

    // Helper function to calculate the largest BST
    private static Info largestBstUtil(Node node) {
        // Base case: An empty tree is a BST of size 0
        if (node == null) {
            return new Info(0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }
        
        // Recursively get the info of the left and right subtrees
        Info leftInfo = largestBstUtil(node.left);
        Info rightInfo = largestBstUtil(node.right);

        // Initialize current node's info
        Info currentInfo = new Info(
            leftInfo.size + rightInfo.size + 1, // Size of the current subtree
            Math.min(node.data, leftInfo.min), // Minimum value in the current subtree
            Math.max(node.data, rightInfo.max), // Maximum value in the current subtree
            0, // We'll determine the largestBSTSize next
            false // We'll determine if it's a BST next
        );

        // Check if the current node's subtree is a BST
        if (leftInfo.isBST && rightInfo.isBST && node.data > leftInfo.max && node.data < rightInfo.min) {
            currentInfo.isBST = true;
            currentInfo.largestBSTSize = currentInfo.size; // Current subtree is a BST
        } else {
            currentInfo.isBST = false;
            currentInfo.largestBSTSize = Math.max(leftInfo.largestBSTSize, rightInfo.largestBSTSize); // Take the largest BST size from the left or right subtree
        }

        return currentInfo;
    }
    
}