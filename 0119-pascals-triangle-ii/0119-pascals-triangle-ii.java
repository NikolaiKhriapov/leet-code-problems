class Solution {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> row = new ArrayList<>();
        row.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> current = new ArrayList<>();
            
            current.add(1);
            for (int j = 1; j < i; j++) {
                current.add(row.get(j - 1) + row.get(j));
            }
            current.add(1);
            
            row = current;
        }
        
        return row;
    }
}