class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return visitCell(matrix, target, 0, 0, new HashSet<>());
    }

    private boolean visitCell(int[][] matrix, int target, int r, int c, Set<String> visited) {
        if (
            r >= matrix.length ||
            c >= matrix[0].length ||
            matrix[r][c] > target ||
            visited.contains(String.valueOf(r) + String.valueOf(c))
           ) {
            return false;
        }
        if (matrix[r][c] == target) {
            return true;
        }
        visited.add(String.valueOf(r) + String.valueOf(c));

        return visitCell(matrix, target, r + 1, c, visited) || visitCell(matrix, target, r, c + 1, visited);
    }
}