class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // Arrays.sort(people);
        // int boat=0;
        // int j=people.length-1;
        // int i=0;
        // while(i<=j){
        //     if(people[i]+people[j]<=limit){
        //         i++;
        //         j--;
        //     }
        //     else{
        //         j--;
        //     }
        //     boat++;
        // }
        // return boat;
        
        int[] weightFreq = new int[limit + 1];
        int totalWeight = 0, res = 0;
        int left = 0, right = weightFreq.length - 1;
        for (int p: people) {
            weightFreq[p]++;
        }
        while (left <= right) {
            while(left <= right && weightFreq[right] <= 0) right--;
            while(left <= right && weightFreq[left] <= 0) left++;
            if (left > right) break;
            res++;
            weightFreq[right]--;
            if ((right + left) <= limit) {
                weightFreq[left]--;
            }
         }
        return res;
        
    }
}