class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count the frequency of each task
        int[] frequencies = new int[26];
        for (char task : tasks) {
            frequencies[task - 'A']++;
        }
        
        // Step 2: Find the maximum frequency
        int f_max = 0;
        for (int freq : frequencies) {
            f_max = Math.max(f_max, freq);
        }
        
        // Step 3: Count how many tasks have this maximum frequency
        int n_max = 0;
        for (int freq : frequencies) {
            if (freq == f_max) {
                n_max++;
            }
        }
        
        // Step 4: Calculate the minimum number of intervals required
        int part_count = f_max - 1;
        int part_length = n - (n_max - 1);
        int empty_slots = part_count * part_length;
        int available_tasks = tasks.length - f_max * n_max;
        int idles = Math.max(0, empty_slots - available_tasks);
        
        return tasks.length + idles;
    }
}