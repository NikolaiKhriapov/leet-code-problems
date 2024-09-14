class Solution {
    public String[] findRelativeRanks(int[] score) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < score.length; i++) {
            queue.offer(new int[]{ score[i], i });
        }

        int rank = 0;
        String[] arr = new String[score.length];
        while (!queue.isEmpty()) {
            int[] element = queue.poll();
            
            String value = String.valueOf(rank + 1);
            if (rank == 0) {
                value = "Gold Medal";
            } else if (rank == 1) {
                value = "Silver Medal";
            } else if (rank == 2) {
                value = "Bronze Medal";
            }
            
            rank++;
            arr[element[1]] = value;
        }

        return arr;
    }
}
