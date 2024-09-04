class Solution {
    Integer dp[][];
    public int superEggDrop(int k, int n) {
        dp=new Integer[k+1][n+1];
        return sol(k,n);
    }
    public int sol(int k,int n){
        if(k==1 || n==0 || n==1) return n;
        if(dp[k][n]!=null) return dp[k][n];
        int l=1,h=n;
        int ans=Integer.MAX_VALUE;
        while(l<=h){
            int mid=(l+h)/2;
            int k1=sol(k-1,mid-1);
            int k2=sol(k,n-mid);
            int temp=1+Math.max(k1,k2);
            if(k1<k2) l=mid+1;
            else h=mid-1;
            ans=Math.min(temp,ans);
        }
        return dp[k][n]=ans;
    }
}