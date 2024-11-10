class Solution {
    
    /////////////////////////////// memoization approach ///////////////////////////
//     public int fib(int n) {
//         int[] dp= new int[n+1];
//         return f(n, dp);
//     }
    
//     public int f(int n, int[] dp){
//         if(n<=1) return n;
//         if(dp[n]!=0) return dp[n];
//         int ans= f(n-1, dp)+f(n-2, dp);
//         dp[n]=ans;
//         return ans;
//     }
    
    //////////////////////////////// tabulation approach ///////////////////////////
    
    public int fib(int n){
        if(n<=1) return n;
        int[] dp= new int[n+1];
        dp[0]=0; dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+ dp[i-2];
        }
        return dp[n];
    }
}