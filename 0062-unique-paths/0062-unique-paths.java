class Solution {
    public int uniquePaths(int m, int n) {

        return uniquePaths(m, n, 0, 0, new HashMap<>());
    }

    private int uniquePaths(int m, int n, int row, int col, Map<String, Integer> memo) {
        if (row < 0 || col < 0 || row >= m || col >= n) return 0;
        if (row == m - 1 && col == n - 1) return 1;

        String key = String.valueOf(row) + "-" + String.valueOf(col);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int result = uniquePaths(m, n, row + 1, col, memo) + uniquePaths(m, n, row, col + 1, memo);
        memo.put(key, result);

        return result;
    }
}