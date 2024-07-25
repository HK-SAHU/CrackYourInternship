class Solution {
    public int reversePairs(int[] nums) {
        if(nums==null || nums.length==0) return 0;
         
        return mergeSortAndCount(nums, 0, nums.length-1);
    }
    
    public int mergeSortAndCount(int[] nums, int start, int end){
        int count=0;
        if(start>=end) return 0;
        
        int mid = start+(end - start)/2;
        count += mergeSortAndCount(nums, start, mid);
        count += mergeSortAndCount(nums, mid +1 , end);
        count += merge(nums, start, mid, end);
        return count;
    }
    
    public int merge(int[] nums, int start, int mid, int end){
        int count=0;
        int j =mid+1;   // starting point of right half array
        
        // counting reverse pair
        for (int i = start; i <= mid; i++) {
            while (j <= end && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }
        
        //merging two halves
        
        int n1= mid-start+1;
        int n2= end-mid;
        int[] left= new int[n1];
        int[] right = new int[n2];

        

        for(int i=0; i<n1;i++){
            left[i]=nums[start+i];   //here the start is refreing to the point from where we have to start and start is not changing 
        }

        for(int i=0;i<n2;i++){
            right[i]= nums[mid+1+i];     // here also mid is not changing it is telling us the point tfrom where we have to fill the elements 
        }


        int i=0,k=start;
        j=0;
        
        while(i<n1 && j<n2){
            if(left[i] <= right[j]){    //<= to make it stable algo
                nums[k++]=left[i++];
            }
            else{
                nums[k++]= right[j++];
            }
        }
        while(i<n1){
            nums[k++]=left[i++];
        }
        while(j<n2){
            nums[k++]=right[j++];
        }
       return count; 
    }
}