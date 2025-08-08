class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        List<List<Integer>> result = new ArrayList<>();
        helper(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    private void helper(int[] nums, List<Integer> curr, boolean[] visited, List<List<Integer>> result) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                curr.add(nums[i]);
                visited[i] = true;
                helper(nums, curr, visited, result);
                curr.remove(curr.size() - 1);
                visited[i] = false;;
            }
        }
    }
}

// time  - O(n!)
// space - O(n!)