class Solution {
    public String[] findRelativeRanks(int[] score) {

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < score.length; i++) {
            queue.offer(new int[]{ score[i], i });
        }

        String[] s = { "Gold Medal", "Silver Medal", "Bronze Medal" };
        int rank = 0;

        String[] arr = new String[score.length];
        while (!queue.isEmpty()) {
            int[] e = queue.poll();
            
            String v = String.valueOf(rank + 1);
            if (rank < 3) {
                v = s[rank];
            }
            
            rank++;
            arr[e[1]] = v;
        }

        return arr;
    }
}
