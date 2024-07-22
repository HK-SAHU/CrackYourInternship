class Solution {
    public void sortColors(int[] nums) {
        int n= nums.length;
        int start=0;
        int end= n-1;
        int pivot =0;
        while(pivot<= end){
            if(nums[pivot]==0){
                swap(nums, start, pivot);
                start++;
                pivot++;
            }
            else if(nums[pivot]==1){
                pivot++;
            }
            else{
                swap(nums, pivot, end);
                end--;
            }
        }
    }
            
    public void swap(int[] nums, int i, int j){
        int temp= nums[i];
        nums[i]= nums[j];
        nums[j]=temp;
    }
}