class Solution {
    public int equalPairs(int[][] grid) {
        if (grid == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (grid.length == 0 || grid.length != grid[0].length) {
            return 0;
        }

        Map<String, Integer> mapRows = new HashMap<>();
        for (int r = 0; r < grid.length; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < grid[0].length; c++) {
                sb.append(grid[r][c]).append(",");
            }
            String key = sb.toString();
            mapRows.put(key, mapRows.getOrDefault(key, 0) + 1);
        }

        int pairCount = 0;
        for (int c = 0; c < grid[0].length; c++) {
            StringBuilder sb = new StringBuilder();
            for (int r = 0; r < grid.length; r++) {
                sb.append(grid[r][c]).append(",");
            }
            String key = sb.toString();
            pairCount += mapRows.getOrDefault(key, 0);
        }

        return pairCount;
    }
}