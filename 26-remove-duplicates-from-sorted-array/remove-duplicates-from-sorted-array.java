class Solution {
    public int removeDuplicates(int[] nums) {
        // int start=0;
        // for(int j: nums){
        //     if(start<1 || j > nums[start-1]){
        //         nums[start]=j;
        //         start++;
        //     }
        // }
        // return start;
        
        if (nums.length == 0) {
            return 0;
        }
        
        int i = 1; 
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i - 1]) {
                nums[i] = nums[j]; // this will update the unique element in the same element
                i++;
            }
        }
        return i;
 
    }
}