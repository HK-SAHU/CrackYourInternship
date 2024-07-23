class Solution {
    public int maxArea(int[] height) {
        int n= height.length;
        int left =0;
        int r=0;
        int right= n-1;
        while(left<right){
            int currMax=(right-left)*Math.min(height[left], height[right]);
            if(height[left]<height[right])left++;
            else right--;
            r=Math.max(r,currMax);
        }
        return r;
    }
}