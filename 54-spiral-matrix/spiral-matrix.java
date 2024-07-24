class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;
        List<Integer> sp= new ArrayList<>();
        int topRow=0; int bottomRow=r-1; int rightCol=c-1; int leftCol=0;
        int totalEle=0;
        while(totalEle<r*c){
            //topRow -> leftCol to rightCol
            for(int j = leftCol; j<=rightCol && totalEle<r*c;j++){
                sp.add(matrix[topRow][j]);
                totalEle++;
            }
            topRow++;

            //rightCol -> topRow to bottomRow 
            for(int i = topRow; i<=bottomRow && totalEle<r*c;i++){
                sp.add(matrix[i][rightCol]);
                totalEle++;
            }
            rightCol--;

            //bottomRow -> rightCol to leftCol
            for(int j = rightCol; j>=leftCol && totalEle<r*c;j--){
                sp.add(matrix[bottomRow][j]);
                totalEle++;
            }
            bottomRow--;
            
            //leftCol -> bottomRow to topRow
            for(int i = bottomRow; i>=topRow && totalEle<r*c;i--){
                sp.add(matrix[i][leftCol]);
                totalEle++;
            }
            leftCol++;
        }
        return sp;
    }
}