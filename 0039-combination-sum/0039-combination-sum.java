class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        addCombinationsToList(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void addCombinationsToList(int[] candidates, int target, int start, List<Integer> curr, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                break;
            }
            curr.add(candidates[i]);
            addCombinationsToList(candidates, target - candidates[i], i, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}