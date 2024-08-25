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
    	    	Node root = buildTree(s);
    	    	
                Tree g = new Tree();
                float answer = g.findMedian(root);
                if(answer-(int)answer == 0)
        		    System.out.println((int)answer);
        		else
        		    System.out.println(answer);
                t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Tree
{
    // Function to find the number of nodes in the BST
    private static int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Function to find the kth node during inorder traversal
    private static int findKthNode(Node root, int k) {
        if (root == null) return -1;

        int leftCount = countNodes(root.left);

        // Check if the kth node is the root node itself
        if (leftCount + 1 == k) return root.data;

        // If kth node is in the left subtree
        if (leftCount >= k) return findKthNode(root.left, k);

        // If kth node is in the right subtree
        return findKthNode(root.right, k - leftCount - 1);
    }

    // Function to find the median of the BST
    public static float findMedian(Node root) {
        if (root == null) return 0;

        // Count the number of nodes in the BST
        int nodeCount = countNodes(root);

        // If the number of nodes is odd, return the middle node's value
        if (nodeCount % 2 != 0) {
            return findKthNode(root, (nodeCount + 1) / 2);
        } else {
            // If the number of nodes is even, return the average of the two middle nodes' values
            int leftMiddle = findKthNode(root, nodeCount / 2);
            int rightMiddle = findKthNode(root, (nodeCount / 2) + 1);
            return (leftMiddle + rightMiddle) / 2.0f;
        }
    }
}