class Solution {
    public int equalPairs(int[][] grid) {
        if (grid == null || grid.length == 0 || grid.length != grid[0].length) {
            throw new IllegalArgumentException("Invalid input");
        }

        Map<String, Integer> rowsMap = new HashMap<>();
        for (int r = 0; r < grid.length; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < grid.length; c++) {
                sb.append(grid[r][c]).append(",");
            }
            String key = sb.toString();
            rowsMap.put(key, rowsMap.getOrDefault(key, 0) + 1);
        }

        int pairCount = 0;
        for (int r = 0; r < grid.length; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < grid.length; c++) {
                sb.append(grid[c][r]).append(",");
            }
            String key = sb.toString();
            pairCount += rowsMap.getOrDefault(key, 0);
        }
        
        return pairCount;
    }
}