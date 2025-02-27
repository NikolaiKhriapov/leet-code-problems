class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(1));
        
        for (int i = 2; i <= numRows; i++) {
            List<Integer> prev = list.get(list.size() - 1);
            
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 1; j < i - 1; j++) {
                curr.add(prev.get(j - 1) + prev.get(j));
            }
            curr.add(1);
            
            list.add(curr);
        }

        return list;
    }
}