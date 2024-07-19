class Solution {
    public List<Integer> getRow(int rowIndex) {

        if (rowIndex == 0) return List.of(1);
        if (rowIndex == 1) return List.of(1, 1);

        List<Integer> row = new ArrayList<>();
        List<Integer> prevRow = getRow(rowIndex - 1);
        
        row.add(1);
        for (int i = 1; i < prevRow.size(); i++) {
            row.add(prevRow.get(i - 1) + prevRow.get(i));
        }
        row.add(1);

        return row;
    }
}