class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n) {
            throw new IllegalArgumentException("Invalid input");
        }
        List<List<Integer>> result = new ArrayList<>();
        helper(n, 1, k, new ArrayList<>(), result);
        return result;
    }

    private void helper(int n, int index, int k, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i <= n; i++) {
            list.add(i);
            helper(n, i + 1, k, list, result);
            list.remove(list.size() - 1);
        }
    }
}