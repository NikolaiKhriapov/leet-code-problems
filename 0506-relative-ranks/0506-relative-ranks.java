class Solution {
    public String[] findRelativeRanks(int[] score) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < score.length; i++) {
            pq.add(new int[] {score[i], i});
        }

        String[] result = new String[score.length];
        int rank = 0;
        while (!pq.isEmpty()) {
            int[] el = pq.poll();

            String val = String.valueOf(rank + 1);

            if (rank == 0) val = "Gold Medal";
            else if (rank == 1) val = "Silver Medal";
            else if (rank == 2) val = "Bronze Medal";

            rank++;
            result[el[1]] = val;
        }

        return result;
    }
}