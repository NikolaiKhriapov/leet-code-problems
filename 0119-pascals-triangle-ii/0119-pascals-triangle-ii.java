class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(List.of(1));

        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 1; j < i; j++) {
                curr.add(row.get(j - 1) + row.get(j));
            }
            curr.add(1);
            
            row = curr;
        }
        
        return row;
    }
}