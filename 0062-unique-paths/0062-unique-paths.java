class Solution {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }

        return uniquePaths(m, n, 0, 0, new int[m][n]);
    }

    private int uniquePaths(int m, int n, int row, int col, int[][] memo) {
        if (row < 0 || col < 0 || row >= m || col >= n) {
            return 0;
        }
        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        if (memo[row][col] != 0) {
            return memo[row][col];
        }

        int result = uniquePaths(m, n, row + 1, col, memo) + uniquePaths(m, n, row, col + 1, memo);
        memo[row][col] = result;

        return result;
    }
}