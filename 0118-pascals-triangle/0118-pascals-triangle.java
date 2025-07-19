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
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j <= i - 1; j++) {
                List<Integer> prevRow = result.get(result.size() - 1);
                list.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            list.add(1);
            result.add(list);
        }
        
        return result;
    }
}

// time  - O(n)
// space - O(n)