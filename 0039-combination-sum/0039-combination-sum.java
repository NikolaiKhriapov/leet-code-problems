class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>(), 0, result);
        return result;
    }

    private void helper(int[] candidates, int target, int start, List<Integer> curr, int sum, List<List<Integer>> result) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            curr.add(candidates[i]);
            helper(candidates, target, i, curr, sum + candidates[i], result);
            curr.remove(curr.size() - 1);
        }
    }
}