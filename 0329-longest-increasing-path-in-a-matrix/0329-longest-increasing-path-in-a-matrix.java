class Solution {
    private static final int[][] NEIGHBORS = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int longest = 0;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                longest = Math.max(longest, helper(matrix, r, c, -1, memo));
            }
        }
        return longest;
    }

    private int helper(int[][] matrix, int row, int col, int prev, int[][] memo) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] <= prev) return 0;

        if (memo[row][col] != 0) {
            return memo[row][col];
        }

        int longest = 1;
        for (int[] neighbor : NEIGHBORS) {
            longest = Math.max(longest, 1 + helper(matrix, row + neighbor[0], col + neighbor[1], matrix[row][col], memo));
        }

        memo[row][col] = longest;
        return longest;
    }
}