class Solution {
    public int findCenter(int[][] edges) {
        int one = edges[0][0];
        int two = edges[0][1];

        for (int[] edge : edges) {
            if (edge[0] != one && edge[1] != one) {
                return two;
            }
        }
        return one;
    }
}