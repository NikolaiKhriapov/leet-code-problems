class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = getRow(rows, i);
            rows.add(row);
        }

        return rows;
    }

    public List<Integer> getRow(List<List<Integer>> rows, int rowNum) {
        List<Integer> row = new ArrayList<>();

        if (rowNum == 0) {
            return List.of(1);
        } else if (rowNum == 1) {
            return List.of(1, 1);
        }

        row.add(1);
        List<Integer> prevRow = rows.get(rows.size() - 1);
        for (int i = 1; i < rowNum; i++) {
            Integer value = prevRow.get(i - 1) + prevRow.get(i);
            row.add(value);
        }
        row.add(1);

        return row;
    }
}