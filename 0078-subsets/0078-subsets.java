class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        addSubsetsToList(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void addSubsetsToList(int[] nums, int index, List<Integer> curr, List<List<Integer>> result) {
        result.add(new ArrayList<>(curr));
        
        if (index >= nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            addSubsetsToList(nums, i + 1, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}