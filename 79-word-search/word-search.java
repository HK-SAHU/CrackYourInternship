class Solution {
    public boolean exist(char[][] board, String word) {
        if(board==null ||  board.length==0) return false;
        int rows= board.length;
        int col= board[0].length;
        
        for(int r=0;r<rows;r++){
            for(int c=0;c<col;c++){
                 if(dfs(board, r,c,word, 0)) return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, int r, int c, String word, int wordIndex){
        if(wordIndex==word.length()) return true;
        
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c]!= word.charAt(wordIndex) || board[r][c]==' '){
            return false;
        }
        
        char temp= board[r][c];
        board[r][c]=' ';
        
        boolean found= dfs(board, r + 1, c,word, wordIndex + 1) ||
                        dfs(board, r - 1, c, word, wordIndex + 1) ||
                        dfs(board, r, c + 1,word, wordIndex + 1) ||
                        dfs(board, r, c - 1,word, wordIndex + 1);
        
        board[r][c] = temp;  // Unmark this cell
        
        return found;
        
    }
}