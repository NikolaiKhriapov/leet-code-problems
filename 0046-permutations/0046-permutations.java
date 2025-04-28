class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int n : nums) {
            helper(nums, n, new ArrayList<>(), result);
        }

        return result;
    }

    private void helper(int[] nums, int n, List<Integer> curr, List<List<Integer>> result) {

        curr.add(n);
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int next : nums) {
            if (!curr.contains(next)) {
                helper(nums, next, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }
}