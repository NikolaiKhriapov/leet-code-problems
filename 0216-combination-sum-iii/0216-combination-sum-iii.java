class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0 || n <= 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        helper(k, n, 1, new ArrayList<>(), result);
        return result;
    }

    private void helper(int k, int n, int currNumber, List<Integer> curr, List<List<Integer>> result) {
        if (n == 0) {
            if (k == 0) result.add(new ArrayList<>(curr));
            return;
        }
        if (currNumber > 9) return;

        for (int i = currNumber; i <= 9; i++) {
            curr.add(i);
            helper(k - 1, n - i, i + 1, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}