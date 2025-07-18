class Solution {
    public int equalPairs(int[][] grid) {
        if (grid == null || grid.length == 0 || grid.length != grid[0].length) {
            throw new IllegalArgumentException("Invalid input");
        }

        int size = grid.length;
        Map<String, Integer> rowMap = new HashMap<>();
        int pairCount = 0;
        
        for (int r = 0; r < size; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < size; c++) {
                sb.append(grid[r][c]).append(",");
            }
            String key = sb.toString();
            rowMap.put(key, rowMap.getOrDefault(key, 0) + 1);
        }

        for (int r = 0; r < size; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < size; c++) {
                sb.append(grid[c][r]).append(",");
            }
            String key = sb.toString();
            if (rowMap.containsKey(key)) {
                pairCount += rowMap.get(key);
            }
        }
        
        return pairCount;
    }
}