class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    public static boolean solve(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0; j<board.length;j++){
                if(board[i][j]=='.'){
                    for(char c='1';c<='9';c++){
                        if(isValid(board, i,j,c)){
                            board[i][j]=c;
                            if(solve(board)){
                                return true;
                            }
                            else{
                                board[i][j]='.';   //backtrack
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean isValid(char[][] board, int row, int col, char c){
        // Check the column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) {
                return false;
            }
        }

        // Check the row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == c) {
                return false;
            }
        }

        // Check the 3x3 grid
        int gridRowStart = (row / 3) * 3;
        int gridColStart = (col / 3) * 3;
        for (int i = gridRowStart; i < gridRowStart + 3; i++) {
            for (int j = gridColStart; j < gridColStart + 3; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }

        return true;

    }
}