class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int maxSquare = 0;
        int[] curr = new int[cols];
        int[] prev = new int[cols];
        for (int c = 0; c < cols; c++) {
            prev[c] = matrix[0][c] == '0' ? 0 : 1;
            maxSquare = Math.max(maxSquare, prev[c]);
        }

        for (int r = 1; r < rows; r++) {
            curr[0] = matrix[r][0] == '0' ? 0 : 1;
            maxSquare = Math.max(maxSquare, curr[0]);
            for (int c = 1; c < cols; c++) {
                if (matrix[r][c] == '0') {
                    curr[c] = 0;
                    continue;
                }
                curr[c] = 1 + Math.min(curr[c - 1], Math.min(prev[c], prev[c - 1]));
                maxSquare = Math.max(maxSquare, curr[c]);
            }
            int[] temp = curr;
            curr = prev;
            prev = temp;
        }
        
        return maxSquare * maxSquare;
    }
}

// time  - O(m*n)
// space - O(n)