//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static void floodFillUntil(char[][] a, int row, int col, char dollar, char newX){
        if(row<0 || row>=a.length || col<0 || col>=a[0].length) return;
        
        if(a[row][col]!= dollar) return;
        
        a[row][col]= newX;   // replace the color at (row, col)
        
        // recur for all directions
        floodFillUntil(a, row+1,col, dollar, newX);
        floodFillUntil(a, row-1,col, dollar, newX);
        floodFillUntil(a, row,col+1, dollar, newX);
        floodFillUntil(a, row,col-1, dollar, newX);
        
    }
    
    static char[][] fill(int n, int m, char a[][])
    {
        // Step 1: Replace all 'O' with '$'
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]=='O'){
                    a[i][j]='$';
                }
            }
        }
        
        // Step 2: Flood fill for all the '$' lying on the edges
        
        // Left side
        for(int i=0;i<n;i++){
            if(a[i][0]=='$'){
                floodFillUntil(a, i, 0, '$', 'O');
            }
        }
        
        // Right side
        for(int i=0;i<n;i++){
            if(a[i][m-1]=='$'){
                floodFillUntil(a, i, m-1, '$', 'O');
            }
        }
        
        // Top side
        for(int i=0;i<m;i++){
            if(a[0][i]=='$'){
                floodFillUntil(a, 0, i, '$', 'O');
            }
        }
        
        // Bottom side
        for(int i=0;i<m;i++){
            if(a[n-1][i]=='$'){
                floodFillUntil(a, n-1, i, '$', 'O');
            }
        }
        
        // Step 3: Replace all '$' with 'X'
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]=='$'){
                    a[i][j]='X';
                }
            }
        }
        return a;
    }
}