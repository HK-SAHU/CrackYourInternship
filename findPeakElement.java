public class findPeakElement {
    public static void main(String[] args) {
        int[] arr= {1,100, 101};
        int n= arr.length;
        System.out.println(minCostToMakeElementequal(arr,n));
    }

    // Method to find minimum cost to make all
    // elements equal

    private static int minCostToMakeElementequal(int[] arr, int n) {
        int low, high;
        low= high= arr[0];

        // setting limits for ternary search by
        // smallest and largest element

        for(int i=0;i<n;i++){
            if(low>arr[i]){
                low= arr[i];
            }

            if(high<arr[i]){
                high= arr[i];
            }
        }

        /* loop until difference between low and high
           become less than 3, because after that
           mid1 and mid2 will start repeating
        */

        while((high-low)>2){
            // mid1 and mid2 are representative array
            // equal values of search space
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;
 
            int cost1 = computeCost(arr, n, mid1);
            int cost2 = computeCost(arr, n, mid2);
 
            // if mid2 point gives more total cost,
            // skip third part
            if (cost1 < cost2){
                high = mid2;
            }
                
 
            // if mid1 point gives more total cost,
            // skip first part
            else{
                low = mid1;
            }
                
        }

        // computeCost gets optimum cost by sending
        // average of low and high as mid

        return computeCost(arr, n, (low+high)/2);
        
    }


    // Utility method to compute cost, when
    // all values of array are made equal to mid

    private static int computeCost(int[] arr, int n, int mid) {
        int cost = 0;
        for (int i = 0; i < n; i++){
            cost += Math.abs(arr[i] - mid);
        }
            
        return cost;
    }
}
