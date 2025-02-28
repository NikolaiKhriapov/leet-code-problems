class Solution {
    public int findCenter(int[][] edges) {
        int one = edges[0][0];
        int two = edges[0][1];

        boolean isOne = true;
        boolean isTwo = true;

        for (int[] edge : edges) {
            if (isOne && edge[0] != one && edge[1] != one) {
                isOne = false;
            }
            if (isTwo && edge[0] != two && edge[1] != two) {
                isTwo = false;
            }
        }

        return isOne ? one : two;
    }
}