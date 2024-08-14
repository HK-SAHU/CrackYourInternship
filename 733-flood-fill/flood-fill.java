class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor = image[sr][sc];
        // If the starting pixel is already the target color, return the image as is
        if (startColor != color) {
            dfs(image, sr, sc, startColor, color);
        }
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int startColor, int color) {
        // Check if the current pixel is out of bounds or doesn't match the startColor
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != startColor) {
            return;
        }

        // Update the color of the current pixel
        image[sr][sc] = color;

        // Recursively call dfs for all 4-directional neighbors
        dfs(image, sr - 1, sc, startColor, color); // Up
        dfs(image, sr + 1, sc, startColor, color); // Down
        dfs(image, sr, sc - 1, startColor, color); // Left
        dfs(image, sr, sc + 1, startColor, color); // Right
    }   
}