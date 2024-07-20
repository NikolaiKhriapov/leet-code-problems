class Solution {
    public int countNegatives(int[][] grid) {

        int count = 0;
        int pc = grid.length - 1;
        int pr = grid[0].length - 1;

        while (pc >= 0) {
            while (pr >= 0 && grid[pc][pr] < 0) {
                count++;
                pr--;
            }
            pc--;
            pr = grid[0].length - 1;
        }

        return count;
    }
}