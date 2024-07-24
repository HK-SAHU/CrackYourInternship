class Solution {
    public int subarraySum(int[] nums, int k) {
        int n= nums.length;
        Map<Integer, Integer> mp= new HashMap<>();
        int preSum=0;
        int count=0;
        mp.put(0,1);   // intially adding (0,1) which wil help me further
        for(int i=0;i<n;i++){
            preSum+=nums[i];
            
            int remove = preSum-k;  // calculate s-k
            
            count+=mp.getOrDefault(remove, 0);  // adding the number of the subArray to be removed
            
            mp.put(preSum, mp.getOrDefault(preSum,0)+1); // update the count of prefix sum in the map
        }
        return count;
        
    }
}