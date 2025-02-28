class Solution {
    public int findCenter(int[][] edges) {
        int[] count = new int[edges.length + 2];

        for (int[] edge : edges) {
            count[edge[0]]++;
            count[edge[1]]++;
        }

        for (int i = 1; i < count.length; i++) {
            if (count[i] == edges.length) {
                return i;
            }
        }
        return -1;
    }
}