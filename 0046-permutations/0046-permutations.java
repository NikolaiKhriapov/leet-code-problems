class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        List<List<Integer>> result = new ArrayList<>();
        helper(nums, new ArrayList<>(), new HashSet<>(), result);
        return result;
    }

    private void helper(int[] nums, List<Integer> curr, Set<Integer> visited, List<List<Integer>> result) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
        }

        for (int n : nums) {
            if (visited.add(n)) {
                curr.add(n);
                helper(nums, curr, visited, result);
                curr.remove(curr.size() - 1);
                visited.remove(n);
            }
        }
    }
}

// time  - O(n^2)
// space - O(n^2)