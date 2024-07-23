class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n= nums.length;
        List<List<Integer>> result= new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n-3;i++){
            // avoid duplicates while moving i
            if(i>0 && nums[i]==nums[i-1]) continue;
            for (int j=i+1;j<n-2;j++){
                //avoid duplicates while moving j
                if(j> i+1 && nums[j]==nums[j-1]) continue;
                
                int k=j+1;
                int l=n-1;
                while(k<l){
                    long sum= (long) nums[i]+nums[j]+nums[k]+nums[l];
                    
                    if(sum==target){
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        
                        // skip thr duplicates of k and l
                        while(k<l && nums[k]==nums[k-1]) k++;
                        while(k<l && nums[l]==nums[l+1]) l--;
                    }
                    else if(sum<target) k++;
                    else l--;
                }
            }
        }
        return result;
    }
}