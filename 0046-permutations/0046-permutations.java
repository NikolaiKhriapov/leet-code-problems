class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(nums, new ArrayList<>(), result, used);
        return result;
    }

    private void helper(int[] nums, List<Integer> curr, List<List<Integer>> result, boolean[] used) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                curr.add(nums[i]);
                used[i] = true;
                helper(nums, curr, result, used);
                curr.remove(curr.size() - 1);
                used[i] = false;
            }
        }
    }
}