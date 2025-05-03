class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        helper(nums, new ArrayList<>(), result, new boolean[nums.length]);
        return result;
    }

    private void helper(int[] nums, List<Integer> curr, List<List<Integer>> result, boolean[] visited) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            curr.add(nums[i]);
            visited[i] = true;
            helper(nums, curr, result, visited);
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }
}