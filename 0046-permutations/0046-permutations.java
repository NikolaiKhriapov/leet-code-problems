class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> curr, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for (int n : nums) {
            if (!curr.contains(n)) {
                curr.add(n);
                helper(nums, index + 1, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }
}