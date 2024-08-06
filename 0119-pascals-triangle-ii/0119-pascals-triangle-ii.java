class Solution {
    public List<Integer> getRow(int rowIndex) {        
        if (rowIndex == 0) return List.of(1);
        if (rowIndex == 1) return List.of(1, 1);

        List<Integer> curr = new ArrayList<>();
        List<Integer> prev = getRow(rowIndex - 1);

        curr.add(1);
        for (int i = 1; i < rowIndex; i++) {
            curr.add(prev.get(i - 1) + prev.get(i));
        }
        curr.add(1);

        return curr;
    }
}