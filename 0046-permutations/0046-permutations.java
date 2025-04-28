class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, new ArrayList<>(), new HashSet<>(), result);
        return result;
    }

    private void helper(int[] nums, List<Integer> curr, Set<Integer> visited, List<List<Integer>> result) {

        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int n : nums) {
            if (!visited.contains(n)) {
                curr.add(n);
                visited.add(n);

                helper(nums, curr, visited, result);

                curr.remove(curr.size() - 1);
                visited.remove(n);
            }
        }
    }
}