class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));

        if (numRows == 1) {
            return result;
        }
        
        for (int i = 2; i <= numRows; i++) {
            List<Integer> prev = result.get(result.size() - 1);
            result.add(getRow(i, prev));
        }

        return result;
    }

    public List<Integer> getRow(int rowNumber, List<Integer> prev) {

        List<Integer> row = new ArrayList<>();
        row.add(1);

        for (int i = 1; i < rowNumber - 1; i++) {
            Integer sum = prev.get(i - 1) + prev.get(i);
            row.add(sum);
        }

        row.add(1);

        return row;
    }
}