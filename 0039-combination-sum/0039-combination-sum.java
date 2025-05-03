class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] candidates, int target, List<Integer> curr, List<List<Integer>> result) {
        int sum = getSum(curr);

        if (sum > target) {
            return;
        } else if (sum == target) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            int currSize = curr.size();
            if (currSize > 0 && candidates[i] < curr.get(currSize - 1)) continue;
            curr.add(candidates[i]);
            helper(candidates, target, curr, result);
            curr.remove(currSize);
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