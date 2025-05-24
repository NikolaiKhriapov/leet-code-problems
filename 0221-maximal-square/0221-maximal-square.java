class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int diag;
        int[] dpCurr = new int[matrix[0].length];
        int maxSide = 0;

        for (int col = 0; col < matrix[0].length; col++) {
            dpCurr[col] = matrix[0][col] - '0';
            maxSide = Math.max(maxSide, dpCurr[col]);
        }

        for (int row = 1; row < matrix.length; row++) {
            diag = dpCurr[0];
            dpCurr[0] = matrix[row][0] - '0';            
            maxSide = Math.max(maxSide, dpCurr[0]);
            for (int col = 1; col < matrix[0].length; col++) {
                int temp = dpCurr[col];
                dpCurr[col] = (matrix[row][col] == '1')
                    ? (1 + Math.min(diag, Math.min(dpCurr[col], dpCurr[col - 1])))
                    : 0;
                diag = temp;
                maxSide = Math.max(maxSide, dpCurr[col]);
            }
        }

        return maxSide * maxSide;
    }
}