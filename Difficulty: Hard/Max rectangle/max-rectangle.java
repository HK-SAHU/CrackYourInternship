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
    
    
    public int maxArea(int M[][], int n, int m) {
        if(n==0) return 0;
        int[] heights= new int[m];
        int maxArea=0;
        
        for(int row[]: M){
            for(int j=0;j<m;j++){
                
                heights[j]=row[j]==1? heights[j]+1:0;
            }
            maxArea=Math.max(maxArea, largestRectangleArea(heights));
        }
        
        return maxArea;
        
    }
}