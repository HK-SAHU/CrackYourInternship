//{ Driver Code Starts
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Main {
    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
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
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            String[] ab = br.readLine().trim().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            GfG g = new GfG();
            System.out.println(g.findDist(root, a, b));
        }
    }
}


// } Driver Code Ends


// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

/* Should return minimum distance between a and b
   in a tree with given root*/
class GfG {
    // Function to find the LCA (Lowest Common Ancestor) of two nodes a and b
    Node findLCA(Node root, int a, int b) {
        if (root == null) return null;

        // If either a or b matches with root's data, return root
        if (root.data == a || root.data == b) return root;

        // Look for keys in left and right subtrees
        Node leftLCA = findLCA(root.left, a, b);
        Node rightLCA = findLCA(root.right, a, b);

        // If both of the above calls return Non-NULL, then one key is present
        // in one subtree and other is present in other, so this node is the LCA
        if (leftLCA != null && rightLCA != null) return root;

        // Otherwise check if left subtree or right subtree is LCA
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    // Function to find the distance from the LCA to a given node
    int findLevel(Node root, int a, int level) {
        if (root == null) return -1;
        if (root.data == a) return level;

        int left = findLevel(root.left, a, level + 1);
        if (left == -1) {
            return findLevel(root.right, a, level + 1);
        }
        return left;
    }

    // Function to find the distance between two given nodes
    int findDist(Node root, int a, int b) {
        // Find the LCA of the two nodes
        Node lca = findLCA(root, a, b);

        // Find the distance from LCA to a and LCA to b
        int d1 = findLevel(lca, a, 0);
        int d2 = findLevel(lca, b, 0);

        return d1 + d2;
    }
}