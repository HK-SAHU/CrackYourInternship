//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputline[i]);
            }
            Solution obj = new Solution();
            Node res = obj.Bst(arr, n);
            printPostorder(res);
            System.out.println();
        }
    }

    
// } Driver Code Ends
// User function Template for Java

/*
class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

static class Solution {
    // Index to keep track of the current position in the preorder array
    int index = 0;

    // Function that constructs BST from its preorder traversal.
    public Node Bst(int pre[], int size) {
        if (size == 0) return null;

        return constructBST(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Helper function to construct the BST using bounds
    private Node constructBST(int[] pre, int min, int max) {
        // If all elements are processed or current element is out of the valid range
        if (index == pre.length || pre[index] < min || pre[index] > max) {
            return null;
        }

        // The current element of preorder is within the range, so it belongs to the current subtree
        int rootValue = pre[index++];
        Node root = new Node(rootValue);

        // All elements smaller than rootValue will be in the left subtree
        root.left = constructBST(pre, min, rootValue);

        // All elements greater than rootValue will be in the right subtree
        root.right = constructBST(pre, rootValue, max);

        return root;
    }
}

//{ Driver Code Starts.

    public static void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void printPostorder(Node node) {
        if (node == null) {
            return;
        }
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void printPreorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }
}
// } Driver Code Ends