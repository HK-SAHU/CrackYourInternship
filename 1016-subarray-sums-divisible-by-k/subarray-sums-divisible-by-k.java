class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] map= new int[k];
        map[0]=1;
        int sum=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int mod= sum%k;
            if(mod<0){
                mod=mod%k+k;
            }
            count+=map[mod];
            map[mod]++;
        }
        return count;
        
    }
}