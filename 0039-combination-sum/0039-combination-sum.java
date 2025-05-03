class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] candidates, int target, int start, List<Integer> curr, List<List<Integer>> result) {
        int sum = getSum(curr);

        if (sum > target) {
            return;
        } else if (sum == target) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            curr.add(candidates[i]);
            helper(candidates, target, i, curr, result);
            curr.remove(curr.size() - 1);
        }
    }

    private int getSum(List<Integer> list) {
        int sum = 0;
        for (int n : list) {
            sum += n;
        }
        return sum;
    }
}