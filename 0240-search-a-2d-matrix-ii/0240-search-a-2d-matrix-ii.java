class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int r = matrix.length - 1;
        int c = 0;

        while (r >= 0 && c < matrix[0].length) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                r--;
                if (r < 0) {
                    return false;
                }
            } else {
                c++;
                if (c == matrix[0].length) {
                    return false;
                }
            }
        }
        
        return false;
    }
}

// time  - O(m + n)
// space - O(1)