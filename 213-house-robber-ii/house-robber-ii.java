class Solution {
    public int robbery(int[] nums, int start, int end) {
        if(start==end) return nums[start];
        int n= nums.length;
        int[] dp= new int[end- start+1];
        dp[0]= nums[start];
        dp[1]=Math.max(nums[start], nums[start+1]);
        for(int i=2;i<dp.length;i++){
            dp[i]= Math.max(nums[start+i]+dp[i-2], dp[i-1]);
        }
        return dp[dp.length-1];
    }
    
    public int rob(int[] nums){
        int n= nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        
        int excFirst= robbery(nums, 0, n-2);
        int excLast= robbery(nums, 1,n-1);
        return Math.max(excFirst, excLast);
    }
}