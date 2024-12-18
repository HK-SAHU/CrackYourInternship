//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    static class Item{
        double val , weight, ratio;
        Item(double val, double weight){
            this.val=val;
            this.weight=weight;
            this.ratio=val/weight;
        }
    }
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        List<Item> li= new ArrayList<>();
        for(int i=0;i<val.size();i++){
            li.add(new Item(val.get(i), wt.get(i)));
        }
        li.sort((a,b) -> Double.compare(b.ratio, a.ratio));
        double res=0.0;
        for(Item item:li){
            if(item.weight<=capacity){
                res+=item.val;
                capacity-=item.weight;
            }
            else{
                res+=item.ratio*capacity;
                break;
            }
        }
        return res;
    }
}