class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (n < 0 || k < 0 || k > n) {
            throw new IllegalArgumentException("Invalid input");
        }

        List<List<Integer>> result = new ArrayList<>();
        helper(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private void helper(int n, int k, int start, List<Integer> curr, List<List<Integer>> result) {
        if (curr.size() == k) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i <= n; i++) {
            curr.add(i);
            helper(n, k, i + 1, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}