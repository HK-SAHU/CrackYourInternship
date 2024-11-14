class Solution {
//     public int rob(int[] nums) {
//         return takeSkip(nums, 0);
//     }
    
    // public int takeSkip(int[] nums, int i){
    //     if(i>=nums.length) return 0;
    //     int take= nums[i]+ takeSkip(nums,i+2);
    //     int skip= takeSkip(nums, i+1);
    //     return Math.max(take, skip);
    // }
    ///////////////////// memoization //////////////////////
    
//     public int rob(int[] nums) {
//         int n=nums.length;
//         int[] dp= new int[n];
//         Arrays.fill(dp,-1);
//         return takeSkip(nums, 0, dp);
//     }
    
//     public int takeSkip(int[] nums, int i, int[] dp){
//         if(i>=nums.length) return 0;
//         if(dp[i]!=-1) return dp[i];
//         int take= nums[i]+ takeSkip(nums,i+2, dp);
//         int skip= takeSkip(nums, i+1, dp);
//         return dp[i]=Math.max(take, skip);
//     }
    
    
    //////////////////// tabulation ///////////////////////////
    
    public int rob(int[] nums){
        int n=nums.length;
        int[] dp= new int[n];
        dp[0]=nums[0];
        if(n>1) dp[1]= Math.max(nums[0], nums[1]);
        for(int i=2;i<n;i++){
            dp[i]= Math.max(nums[i]+ dp[i-2], dp [i-1]);
        }
        return dp[n-1];
        
    }
}