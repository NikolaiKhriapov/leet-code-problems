class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        if (numRows > 0) result.add(List.of(1));

        if (numRows > 1) {
            for (int i = 2; i <= numRows; i++) {
                List<Integer> v = handleRow(result.get(result.size() - 1));
                result.add(v);
            }
        }

        return result;
    }

    public List<Integer> handleRow(List<Integer> prev) {
        List<Integer> curr = new ArrayList<>(List.of(1));
        
        for (int i = 1; i < prev.size(); i++) {
            curr.add(prev.get(i - 1) + prev.get(i));
        }
        curr.add(1);
        
        return curr;
    }
}