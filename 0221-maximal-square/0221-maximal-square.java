class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] prev = new int[cols];
        int[] curr = new int[cols];
        int max = 0;
        
        for (int col = 0; col < cols; col++) {
            prev[col] = matrix[0][col] - '0';
            max = Math.max(max, prev[col]);
        }

        for (int row = 1; row < rows; row++) {
            curr[0] = matrix[row][0] - '0';
            max = Math.max(max, curr[0]);
            for (int col = 1; col < cols; col++) {
                curr[col] = (matrix[row][col] == '1')
                    ? (1 + Math.min(curr[col - 1], Math.min(prev[col], prev[col - 1])))
                    : 0;
                max = Math.max(max, curr[col]);
            }
            prev = Arrays.copyOf(curr, curr.length);
        }

        return max * max;
    }
}

// [1,0,1,0,0]
// [1,0,1,1,1]
// [1,1,1,2,2]
// [1,0,0,1,0]
