class Solution {
    
     private boolean isValidNeighbor(int x, int y, int[][] board) {
        return (x >= 0 && x < board.length && y >= 0 && y < board[0].length);
    }
    
    public void gameOfLife(int[][] board) {
        int[] dx={0,0,1,1,1,-1,-1,-1};
        int[] dy={1,-1,1,0,-1,1,0,-1};
        
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                int countLiveNeighbours=0;
                
                for(int i=0;i<8;i++){
                    int curr_x=row+dx[i];
                    int curr_y=col+dy[i];
                    if(isValidNeighbor(curr_x,curr_y,board) && Math.abs(board[curr_x][curr_y])==1) countLiveNeighbours++;
                }
                
                if(board[row][col]==1 && (countLiveNeighbours<2 || countLiveNeighbours>3)){
                    board[row][col]=-1;   //dies
                }
                
                if(board[row][col]==0 && (countLiveNeighbours==3 )){
                    board[row][col]=2;   //alive
                }
            }
        }
        
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                if(board[row][col]>=1){    //1 or 2
                    board[row][col]=1;
                }
                else{
                    board[row][col]=0;
                }
            }
        }
    }
}