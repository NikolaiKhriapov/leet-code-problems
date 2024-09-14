class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> curr, int[] nums) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
        } else {
            for (int n : nums) {
                if (curr.contains(n)) continue;

                curr.add(n);
                backtrack(result, curr, nums);
                curr.remove(curr.size() - 1);
            }
        }
    }
}