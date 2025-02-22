class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<Integer>[] map = new List[101];
        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < mat.length; i++) {
            int n = helper(mat[i]);
            map[n].add(i);
        }
        
        int[] result = new int[k];
        for (int i = 0; i <= mat[0].length; i++) {
            if (map[i].size() > 0) {
                for (int n : map[i]) {
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