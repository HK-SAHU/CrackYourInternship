/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// class Solution {
//     public int widthOfBinaryTree(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }
        
//         int maxWidth = 0;
//         // Queue will store pairs of (node, index)
//         Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
//         queue.offer(new Pair<>(root, 0));
        
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             int firstIndex = queue.peek().getValue(); // Get the index of the first node at the current level
//             int lastIndex = firstIndex; // Initialize the lastIndex
            
//             for (int i = 0; i < size; i++) {
//                 Pair<TreeNode, Integer> current = queue.poll();
//                 TreeNode node = current.getKey();
//                 int index = current.getValue();
                
//                 // Enqueue left child with the appropriate index
//                 if (node.left != null) {
//                     queue.offer(new Pair<>(node.left, 2 * index + 1));
//                 }
                
//                 // Enqueue right child with the appropriate index
//                 if (node.right != null) {
//                     queue.offer(new Pair<>(node.right, 2 * index + 2));
//                 }
                
//                 lastIndex = index; // Update lastIndex
//             }
            
//             // Calculate width of the current level
//             int currentWidth = lastIndex - firstIndex + 1;
//             maxWidth = Math.max(maxWidth, currentWidth);
//         }
        
//         return maxWidth;
//     }
// }

// // A simple pair class to store nodes with their respective indices
// class Pair<K, V> {
//     private K key;
//     private V value;

//     public Pair(K key, V value) {
//         this.key = key;
//         this.value = value;
//     }

//     public K getKey() {
//         return key;
//     }

//     public V getValue() {
//         return value;
//     }

//     public void setKey(K key) {
//         this.key = key;
//     }

//     public void setValue(V value) {
//         this.value = value;
//     }
// }

class Pair {
    TreeNode node;
    int col;

    public Pair(TreeNode node, int col) {
        this.node = node;
        this.col = col;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0; 
        Queue<Pair> q = new LinkedList<>(); 
        q.add(new Pair(root, 0));

        while(!q.isEmpty()) {
            int size = q.size();

            int temp = q.peek().col;
            for(int i = 0; i < size; i++) {
                Pair p = q.remove();
                
                if(p.node.left != null) q.add(new Pair(p.node.left, (p.col - temp) * 2 + 1));
                if(p.node.right != null) q.add(new Pair(p.node.right, (p.col - temp) * 2 + 2));

                if(i == size - 1) maxWidth = Math.max(p.col - temp + 1, maxWidth);
            }
        }  

        return maxWidth;
    }
}