class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || target < 0) {
            throw new IllegalArgumentException("Invalid input"); // for simplicity
        }
        if (candidates.length == 0 || target == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] candidates, int start, int target, List<Integer> curr, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                continue;
            }
            curr.add(candidates[i]);
            helper(candidates, i, target - candidates[i], curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}