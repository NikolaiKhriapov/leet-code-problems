/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        if (grid == null || grid.length == 0 || grid.length != grid[0].length) {
            throw new IllegalArgumentException("Invalid input");
        }
        return construct(grid, 0, 0, grid.length);
    }

    private Node construct(int[][] grid, int row, int col, int gridSize) {
        if (isLeaf(grid, row, col, gridSize)) {
            boolean value = grid[row][col] == 1;
            return new Node(value, true);
        }

        int sizeHalf = gridSize / 2;
        return new Node(
            false,
            false,
            construct(grid, row, col, sizeHalf),
            construct(grid, row, col + sizeHalf, sizeHalf),
            construct(grid, row + sizeHalf, col, sizeHalf),
            construct(grid, row + sizeHalf, col + sizeHalf, sizeHalf)
        );
    }

    private boolean isLeaf(int[][] grid, int row, int col, int gridSize) {
        int first = grid[row][col];
        for (int r = row; r < row + gridSize; r++) {
            for (int c = col; c < col + gridSize; c++) {
                if (grid[r][c] != first) {
                    return false;
                }
            }
        }
        return true;
    }
}

// time  - O()
// space - O()