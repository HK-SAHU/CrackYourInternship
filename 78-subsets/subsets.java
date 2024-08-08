class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list= new ArrayList<>();
        backtrack(list, new ArrayList<>(), 0, nums);
        return list;
    }
    public void backtrack(List<List<Integer>> list, List<Integer> set, int start, int[] nums ){
        list.add(new ArrayList<>(set));
        for(int i=start; i<nums.length;i++){
            set.add(nums[i]);
            backtrack(list, set, i+1, nums);
            set.remove(set.size()-1);
        }
    }
}