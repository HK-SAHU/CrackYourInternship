class Solution {
    
    /*public void swap(int[] nums1, int last1, int first2){
        int temp=nums1[last1];
        nums1[last1]= nums1[first2];
        nums1[first2]= temp;
    }
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last=m-1;
        int first=m;
        int i =m;
        for(int j=0;j<n;j++){
            nums1[i++]=nums2[j];
        }
        if(n>0){
        while(first<nums1.length){
            if(nums1[last]>nums1[first]){
                swap(nums1, last, first);
                last--;
                first++;
            }
            else{
                last--;
                first++;
            }   
        }
    }
}*/
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last1 = m - 1;
        int last2 = n - 1;
        int mergedIndex = m + n - 1;

        while (last1 >= 0 && last2 >= 0) {
            if (nums1[last1] > nums2[last2]) {
                nums1[mergedIndex--] = nums1[last1--];
            } 
            else {
                nums1[mergedIndex--] = nums2[last2--];
            }
        }

        // If there are remaining elements in nums2, copy them to nums1
        while (last2 >= 0) {
            nums1[mergedIndex--] = nums2[last2--];
        }
    }
}