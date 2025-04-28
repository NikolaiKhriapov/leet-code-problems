class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input"); // for simplicity
        }

        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] nums, int idx, List<Integer> curr, List<List<Integer>> result) {
        result.add(new ArrayList<>(curr));

        for (int i = idx; i < nums.length; i++) {
            curr.add(nums[i]);
            helper(nums, i + 1, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}