class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n= cardPoints.length;
        int leftSum=0;
        int rightSum=0;
        for(int i=0;i<k;i++){
            leftSum+=cardPoints[i];
        }
        int maxScore= leftSum;
        for(int i=0;i<k;i++){
            leftSum-=cardPoints[k-1-i];
            rightSum+=cardPoints[n-1-i];
            maxScore= Math.max(maxScore, leftSum+rightSum);
        }
        return maxScore;
    }
}