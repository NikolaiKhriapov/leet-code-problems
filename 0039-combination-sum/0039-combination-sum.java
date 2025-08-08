class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> curr, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            curr.add(candidates[i]);
            helper(candidates, target - candidates[i], i, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}

// time  - O(n^2)
// space - O(n^2)