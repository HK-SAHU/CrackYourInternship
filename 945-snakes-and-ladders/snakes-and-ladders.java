class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        int moves = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            moves++;
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int next = curr + 1; next <= Math.min(curr + 6, n * n); next++) {
                    int[] pos = getPosition(next, n);
                    int dest = board[pos[0]][pos[1]] == -1 ? next : board[pos[0]][pos[1]];
                    if (dest == n * n) return moves;
                    if (!visited[dest]) {
                        visited[dest] = true;
                        queue.offer(dest);
                    }
                }
            }
        }
        
        return -1;
    }

    private int[] getPosition(int num, int n) {
        int r = (num - 1) / n;
        int c = (num - 1) % n;
        if (r % 2 == 1) c = n - 1 - c;
        return new int[]{n - 1 - r, c};
    }
}