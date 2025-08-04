class Solution {
    public int findCenter(int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0].length != 2) {
            throw new IllegalArgumentException("Invalid input");
        }
        return (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) ? edges[0][0] : edges[0][1];
    }
}

// time  - O(1)
// space - O(1)