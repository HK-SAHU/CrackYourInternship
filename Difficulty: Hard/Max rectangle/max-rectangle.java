//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    
    public static int largestRectangleArea(int[] heights){
        int n= heights.length;
        int[] left=new int[n];
        int[] right= new int[n];
        Stack<Integer> st= new Stack<>();
        
        for(int i =0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            
            if(st.isEmpty()) left[i]=0;
            else left[i]= st.peek()+1;
            st.push(i);
        }
        
        st.clear();
        
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) right[i] = n - 1;
            else right[i] = st.peek() - 1;
            st.push(i);
        }
        
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] + 1));
        }
        return maxArea;
    }
    
    
    public int maxArea(int M[][], int m, int n) {
        // if(n==0) return 0;
        // int[] heights= new int[m];
        // int maxArea=0;
        
        // for(int row[]: M){
        //     for(int j=0;j<m;j++){
                
        //         heights[j]=row[j]==1? heights[j]+1:0;
        //     }
        //     maxArea=Math.max(maxArea, largestRectangleArea(heights));
        // }
        
        // return maxArea;
        
        
        if (M == null || M.length == 0) {
            return 0;
        }
        
        // int m = M.length;
        // int n = M[0].length;
        int[] left = new int[n];   // Array to store the left boundary of consecutive 1's
        int[] right = new int[n];  // Array to store the right boundary of consecutive 1's
        int[] height = new int[n]; // Array to store the height of consecutive 1's
        
        Arrays.fill(right, n);
        int maxArea = 0;
        
        for (int[] row : M) {
            int curLeft = 0, curRight = n;
            
            // Update height array
            for (int j = 0; j < n; j++) {
                if (row[j] == 1) {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            
            // Update left boundary array
            for (int j = 0; j < n; j++) {
                if (row[j] == 1) {
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }
            
            // Update right boundary array
            for (int j = n - 1; j >= 0; j--) {
                if (row[j] == 1) {
                    right[j] = Math.min(right[j], curRight);
                } else {
                    right[j] = n;
                    curRight = j;
                }
            }
            
            // Calculate maximum area for each cell
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
            }
        }
        
        return maxArea;
        
    }
}