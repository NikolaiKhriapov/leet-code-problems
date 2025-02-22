class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            int l = grid[0].length;
            count += (l - helper(grid[i], 0, l - 1));
            System.out.println(helper(grid[i], 0, l - 1));
        }
        
        return count;
    }

    private int helper(int[] row, int l, int r) {
        if (l > r) return l;

        int m = l + (r - l) / 2;

        if (row[m] < 0 && (m == 0 || row[m - 1] >= 0)) return m;
        if (row[m] < 0) return helper(row, l, m - 1);
        return helper(row, m + 1, r);
    }
}