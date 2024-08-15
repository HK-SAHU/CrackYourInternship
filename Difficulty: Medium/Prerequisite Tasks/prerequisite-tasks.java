//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,P,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        // Create adjacency list to represent the graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Create in-degree array
        int[] inDegree = new int[N];
        
        // Build the graph and in-degree array
        for (int[] prereq : prerequisites) {
            int task = prereq[0];
            int prerequisite = prereq[1];
            graph.get(prerequisite).add(task);
            inDegree[task]++;
        }
        
        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        
        // Add all nodes with in-degree 0 to the queue
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int completedTasks = 0;
        
        // Process the queue
        while (!queue.isEmpty()) {
            int task = queue.poll();
            completedTasks++;
            
            // Reduce in-degree of adjacent vertices
            for (int neighbor : graph.get(task)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // If all tasks are completed, return true
        return completedTasks == N;
    }
    
}