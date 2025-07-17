class Solution {
    public int equalPairs(int[][] grid) {

        int size = grid.length;

        Map<String, Integer> rowMap = new HashMap<>();
        Map<String, Integer> colMap = new HashMap<>();
        int countMax = 0;

        for (int r = 0; r < size; r++) {
            StringBuilder rowSb = new StringBuilder();
            StringBuilder colSb = new StringBuilder();
            
            for (int c = 0; c < size; c++) {
                rowSb.append(grid[r][c]).append(",");
                colSb.append(grid[c][r]).append(",");
            }
            
            String rowKey = rowSb.toString();
            String colKey = colSb.toString();            

            rowMap.put(rowKey, rowMap.getOrDefault(rowKey, 0) + 1);
            colMap.put(colKey, colMap.getOrDefault(colKey, 0) + 1);
        }

        for (var entry : rowMap.entrySet()) {
            if (colMap.containsKey(entry.getKey())) {
                countMax += entry.getValue() * colMap.get(entry.getKey());
            }
        }

        return countMax;
    }
}