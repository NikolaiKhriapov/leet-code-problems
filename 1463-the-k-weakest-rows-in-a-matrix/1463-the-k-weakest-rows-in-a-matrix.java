class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < mat.length; i++) {
            int n = helper(mat[i]);
            List<Integer> list = map.getOrDefault(n, new ArrayList<>());
            list.add(i);
            map.put(n, list);
        }
        
        int[] result = new int[k];
        for (int i = 0; i <= mat[0].length; i++) {
            if (map.containsKey(i)) {
                List<Integer> list = map.get(i);
                for (int n : list) {
                    if (k > 0) {
                        result[result.length - k--] = n;
                    }
                }
            }
        }

        return result;
    }

    private int helper(int[] row) {
        int sum = 0;
        for (int n : row) {
            sum += n;
        }
        return sum;
    }
}