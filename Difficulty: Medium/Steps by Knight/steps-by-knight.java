//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    // Possible moves of a knight
    private static final int[][] MOVES = {
        {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
        {1, -2}, {1, 2}, {2, -1}, {2, 1}
    };

    public int minStepToReachTarget(int[] KnightPos, int[] TargetPos, int N) {
        // Convert to 0-based indexing
        int startX = KnightPos[0] - 1;
        int startY = KnightPos[1] - 1;
        int targetX = TargetPos[0] - 1;
        int targetY = TargetPos[1] - 1;

        // If knight is already at target position
        if (startX == targetX && startY == targetY) {
            return 0;
        }

        // Queue for BFS
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        // Start BFS from knight's position
        queue.offer(new int[]{startX, startY, 0}); // x, y, steps
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int steps = current[2];

            // Check if we've reached the target
            if (x == targetX && y == targetY) {
                return steps;
            }

            // Try all possible moves
            for (int[] move : MOVES) {
                int newX = x + move[0];
                int newY = y + move[1];

                // Check if the new position is valid and not visited
                if (isValid(newX, newY, N) && !visited[newX][newY]) {
                    queue.offer(new int[]{newX, newY, steps + 1});
                    visited[newX][newY] = true;
                }
            }
        }

        // If target is not reachable
        return -1;
    }

    private boolean isValid(int x, int y, int N) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}