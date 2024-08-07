class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> li= new ArrayList<>();
        int n = nums.length;
        if(n==0 || n==1) return li;
        for(int i=0;i<nums.length;i++){
            int ele= Math.abs(nums[i]);
            if(nums[ele-1]<0) li.add(ele);
            else nums[ele-1]=-nums[ele-1];  // making the number negative to maintain log
        }
        return li;
        
        // ---------------------------------------------
        // int[] fre= new int[nums.length+1];
        // for(int i=0;i<nums.length;i++){
        //     fre[nums[i]]++;
        //     if(fre[nums[i]]==2){
        //         li.add(nums[i]);
        //     }
        // }
        // return li;
        
    }
}