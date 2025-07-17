class Solution {
    public int equalPairs(int[][] grid) {

        int size = grid.length;

        Map<String, int[]> map = new HashMap<>();
        int countPairs = 0;

        for (int r = 0; r < size; r++) {
            StringBuilder rowSb = new StringBuilder();
            StringBuilder colSb = new StringBuilder();
            for (int c = 0; c < size; c++) {
                rowSb.append(grid[r][c]).append(",");
                colSb.append(grid[c][r]).append(",");
            }
            String rowKey = rowSb.toString();
            int[] rowValue = map.getOrDefault(rowKey, new int[2]);
            rowValue[0]++;
            map.put(rowKey, rowValue);

            String colKey = colSb.toString();
            int[] colValue = map.getOrDefault(colKey, new int[2]);
            colValue[1]++;
            map.put(colKey, colValue);
        }

        for (int[] value : map.values()) {
            countPairs += value[0] * value[1];
        }

        return countPairs;
    }
}