class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] dpPrev = new int[cols];        
        int[] dpCurr = new int[cols];
        int maxSide = 0;

        for (int col = 0; col < cols; col++) {
            dpPrev[col] = matrix[0][col] - '0';
            maxSide = Math.max(maxSide, dpPrev[col]);
        }

        for (int row = 1; row < rows; row++) {
            dpCurr[0] = matrix[row][0] - '0';
            maxSide = Math.max(maxSide, dpCurr[0]);
            for (int col = 1; col < cols; col++) {
                dpCurr[col] = (matrix[row][col] == '1')
                    ? (1 + getMin(dpCurr[col - 1], dpPrev[col - 1], dpPrev[col]))
                    : 0;
                maxSide = Math.max(maxSide, dpCurr[col]);
            }
            dpPrev = Arrays.copyOf(dpCurr, dpCurr.length);
        }

        return maxSide * maxSide;
    }

    private int getMin(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}

// [1,0,1,0,0]
// [1,0,1,1,1]
// [1,1,1,2,2]
// [1,0,0,1,0]
//  2 * 2 = 4