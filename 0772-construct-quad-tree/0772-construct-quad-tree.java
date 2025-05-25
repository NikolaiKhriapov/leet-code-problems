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
        return construct(grid, 0, 0, grid.length);
    }

    private Node construct(int[][] grid, int row, int col, int size) {
        if (isLeaf(grid, row, col, size)) {
            return new Node(grid[row][col] == 1, true);
        }

        int halfSize = size / 2;
        return new Node(
            false,
            false,
            construct(grid, row, col, halfSize),
            construct(grid, row, col + halfSize, halfSize),
            construct(grid, row + halfSize, col, halfSize),
            construct(grid, row + halfSize, col + halfSize, halfSize)
        );
    }

    private boolean isLeaf(int[][] grid, int row, int col, int size) {
        int first = grid[row][col];
        for (int r = row; r < row + size; r++) {
            for (int c = col; c < col + size; c++) {
                if (grid[r][c] != first) {
                    return false;
                }
            }
        }
        return true;
    }
}