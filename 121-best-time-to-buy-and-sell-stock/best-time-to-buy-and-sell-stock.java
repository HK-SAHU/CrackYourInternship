class Solution {
    public int maxProfit(int[] prices) {
        int mini=prices[0];
        int maxProfit=0;
        int n= prices.length;
        for(int i=0;i<n;i++){
            int cost=prices[i]-mini;
            maxProfit=Math.max(cost,maxProfit);
            mini=Math.min(mini, prices[i]);
        }
        return maxProfit;
    }
}