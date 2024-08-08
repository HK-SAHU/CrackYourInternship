class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list= new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used= new boolean[nums.length];
        backtrack(list, new ArrayList<>(), nums, used);
        return list;
    }
    
    public void backtrack(List<List<Integer>> list, List<Integer> set , int[] nums, boolean[] used){
        if(set.size()==nums.length){
            list.add(new ArrayList(set));
            return;
        }
        
        for(int i= 0;i<nums.length;i++){
            if(used[i] || i>0 && nums[i]== nums[i-1] && !used[i-1]) continue;
            
            used[i]= true;
            set.add(nums[i]);
            backtrack(list, set, nums, used);
            set.remove(set.size()-1);
            used[i]= false;
        }
    }
}