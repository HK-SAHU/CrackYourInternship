import java.util.ArrayList;
import java.util.List;

class BinaryTreePathSum {

    // Binary tree node class
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = right = null;
        }
    }

    // List to store the current path from root to the node
    static List<Integer> currentPath = new ArrayList<>();

    // Utility function to print a sublist from a specific index to the end
    static void printPath(List<Integer> path, int startIndex) {
        for (int i = startIndex; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }

    // Function to find and print all paths with the sum 'k'
    static void findPathsWithSumK(Node root, int k) {
        // Base case: if the current node is null, return
        if (root == null) {
            return;
        }

        // Add the current node's data to the path
        currentPath.add(root.data);

        // Recursive call to the left child
        findPathsWithSumK(root.left, k);

        // Recursive call to the right child
        findPathsWithSumK(root.right, k);

        // Check all sub-paths ending at this node to see if any sums to 'k'
        int pathSum = 0;
        for (int j = currentPath.size() - 1; j >= 0; j--) {
            pathSum += currentPath.get(j);

            // If a sub-path sums to 'k', print it
            if (pathSum == k) {
                printPath(currentPath, j);
            }
        }

        // Remove the current node from the path before returning to the caller
        currentPath.remove(currentPath.size() - 1);
    }

    // Wrapper function to start the path-finding process
    static void printPathsWithSumK(Node root, int k) {
        currentPath = new ArrayList<>();
        findPathsWithSumK(root, k);
    }

    // Main function to test the path-sum function
    public static void main(String[] args) {
        // Creating the binary tree
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.left.right.left = new Node(1);
        root.right = new Node(-1);
        root.right.left = new Node(4);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right = new Node(5);
        root.right.right.right = new Node(2);

        int k = 5;

        // Print all paths with sum 'k'
        printPathsWithSumK(root, k);
    }
}
