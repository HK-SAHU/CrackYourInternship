//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
	            String[] ab = br.readLine().trim().split(" ");
                int a = Integer.parseInt(ab[0]);
                int b = Integer.parseInt(ab[1]);
    	    	Node root = buildTree(s);
        	    Solution g = new Solution();
			    System.out.println(g.getCount(root,a,b));
                t--;
            
        }
    }
  
}


// } Driver Code Ends


// A Binary Search Tree node


class Solution
{
    // Function to count number of nodes in BST that lie in the given range.
    int getCount(Node root, int l, int h) {
        if (root == null) {
            return 0; // Base case: if the node is null, return 0
        }

        // If the current node's data is within the range [l, h]
        if (root.data >= l && root.data <= h) {
            // Count this node and search both left and right subtrees
            return 1 + getCount(root.left, l, h) + getCount(root.right, l, h);
        }
        // If the current node's data is less than the lower bound l
        else if (root.data < l) {
            // All nodes in the left subtree are also less, so skip the left subtree
            return getCount(root.right, l, h);
        }
        // If the current node's data is greater than the upper bound h
        else {
            // All nodes in the right subtree are also greater, so skip the right subtree
            return getCount(root.left, l, h);
        }
    }
}
