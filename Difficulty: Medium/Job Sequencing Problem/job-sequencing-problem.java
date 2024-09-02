//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Sort jobs in decreasing order of profit
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);

        // To keep track of free time slots
        boolean[] result = new boolean[n];
        // To store result (Sequence of jobs)
        int[] jobSequence = new int[n];

        // Initialize result
        for (int i = 0; i < n; i++) {
            result[i] = false;
        }

        // Iterate through all given jobs
        int countJobs = 0, maxProfit = 0;
        for (int i = 0; i < n; i++) {
            // Find a free slot for this job (Note that we start from the last possible slot)
            for (int j = Math.min(n, arr[i].deadline) - 1; j >= 0; j--) {
                // Free slot found
                if (!result[j]) {
                    result[j] = true;
                    jobSequence[j] = i;
                    countJobs++;
                    maxProfit += arr[i].profit;
                    break;
                }
            }
        }

        return new int[]{countJobs, maxProfit};
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/