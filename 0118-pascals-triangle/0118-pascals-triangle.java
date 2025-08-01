class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (numRows == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = result.get(result.size() - 1);
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            for (int j = 1; j < i; j++) {
                currRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            currRow.add(1);
            result.add(currRow);
        }
        
        return result;
    }
}

// time  - O(n2)
// space - O(n2)