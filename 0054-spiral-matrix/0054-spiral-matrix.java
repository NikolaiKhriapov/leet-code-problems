class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int t = 0;
        int b = matrix.length - 1;
        int l = 0;
        int r = matrix[0].length - 1;

        while (t <= b && l <= r) {
            for (int i = l; i <= r; i++) {
                result.add(matrix[t][i]);
            }
            t++;

            for (int i = t; i <= b; i++) {
                result.add(matrix[i][r]);
            }
            r--;

            if (t <= b) {
                for (int i = r; i >= l; i--) {
                    result.add(matrix[b][i]);
                }
                b--;
            }

            if (l <= r) {
                for (int i = b; i >= t; i--) {
                    result.add(matrix[i][l]);
                }
                l++;
            }
        }
        
        return result;
    }
}