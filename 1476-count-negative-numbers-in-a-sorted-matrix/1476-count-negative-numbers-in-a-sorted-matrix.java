class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int p = 0;

        for (int i = grid.length - 1; i >= 0; i--) {
            while (p < grid[0].length && grid[i][p] >= 0) {
                p++;
            }
            count += grid[0].length - p;
        }
        
        return count;
    }
}